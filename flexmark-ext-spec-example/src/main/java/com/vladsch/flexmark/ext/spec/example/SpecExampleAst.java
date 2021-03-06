package com.vladsch.flexmark.ext.spec.example;

import com.vladsch.flexmark.util.ast.CustomNode;
import com.vladsch.flexmark.util.sequence.BasedSequence;

/**
 * A SpecExample block node
 */
public class SpecExampleAst extends CustomNode {
    @Override
    public void getAstExtra(StringBuilder out) {
        astExtraChars(out);
    }

    @Override
    public BasedSequence[] getSegments() {
        return EMPTY_SEGMENTS;
    }

    public SpecExampleAst() {
    }

    public SpecExampleAst(BasedSequence chars) {
        super(chars);
    }
}
