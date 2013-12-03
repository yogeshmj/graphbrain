package com.graphbrain.db;

import java.util.Map;

public class EdgeType extends Vertex {

    private String label;

    @Override
    public VertexType type() {return VertexType.EdgeType;}

    public EdgeType(String id, String label, int degree, long ts) {
        super(id, degree, ts);
        this.label = label;
    }

    public EdgeType(String id, Map<String, String> map) {
        super(id, map);
        label = map.get("label");
    }

    public EdgeType(String id, String label) {
        this(id, label, 0, -1);
    }

    public EdgeType(String id) {
        this(id, "");
    }

    @Override
    public Vertex copy() {
        return new EdgeType(id, label, degree, ts);
    }

    @Override
    protected void fillMap(Map<String, String> map) {
        map.put("label", label);
    }

    public static boolean isNegative(String id) {
        return ID.parts(id)[0].equals("neg");
    }

    public boolean isNegative() {
        return isNegative(id);
    }
}