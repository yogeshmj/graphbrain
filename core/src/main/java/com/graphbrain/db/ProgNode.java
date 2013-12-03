package com.graphbrain.db;

import java.util.Map;

public class ProgNode extends Vertex {

    private String prog;

    @Override
    public VertexType type() {return VertexType.Prog;}

    public ProgNode(String id, String prog, int degree, long ts) {
        super(id, degree, ts);
        this.prog = prog;
    }

    public ProgNode(String id, Map<String, String> map) {
        super(id, map);
        prog = map.get("prog");
    }

    public ProgNode(String id, String prog) {
        this(id, prog, 0, -1);
    }

    @Override
    public Vertex copy() {
        return new ProgNode(id, prog, degree, ts);
    }

    @Override
    protected void fillMap(Map<String, String> map) {
        map.put("prog", prog);
    }
}