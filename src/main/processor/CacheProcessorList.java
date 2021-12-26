package main.processor;

import main.models.AddressList;
import main.outer.Printable;

import java.util.ArrayList;

public class CacheProcessorList {
    private ArrayList<CacheProcessor> processors;

    public CacheProcessorList(ArrayList<CacheProcessor> processors) {
        this.processors = processors;
    }

    public static CacheProcessorList create(Cacheable[] cacheables, AddressList addressList) {
        final var processors = new ArrayList<CacheProcessor>();
        for (var cacheable: cacheables) {
            processors.add(new CacheProcessor(cacheable, addressList));
        }
        return new CacheProcessorList(processors);
    }

    public void out(Printable outer) {
        for (var processor: processors) {
            outer.println(processor.result());
        }
    }
}
