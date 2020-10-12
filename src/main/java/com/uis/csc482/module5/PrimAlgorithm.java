package com.uis.csc482.module5;

import com.uis.csc482.module4.Edge;
import com.uis.csc482.module4.GraphLanguage;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class PrimAlgorithm {

    private void processPrimAlgorithm() throws IOException {

        GraphLanguage graphLanguage = new GraphLanguage();
        Map<String, List<Edge>> stringListMap =  graphLanguage.processFile("/src/main/java/com/uis/csc482/module5/Prim_000.gl");
    }
}
