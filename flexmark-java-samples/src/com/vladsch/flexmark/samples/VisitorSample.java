package com.vladsch.flexmark.samples;

import com.vladsch.flexmark.ast.*;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.ast.NodeVisitor;
import com.vladsch.flexmark.util.ast.VisitHandler;
import com.vladsch.flexmark.util.ast.Visitor;

@SuppressWarnings({ "unchecked", "WeakerAccess" })
public class VisitorSample {
    int wordCount;

    // example of visitor for a node or nodes, just add VisitHandlers<> to the list
    // any node type not handled by the visitor will default to visiting its children
    NodeVisitor visitor = new NodeVisitor(
            new VisitHandler<Text>(Text.class, new Visitor<Text>() {
                @Override
                public void visit(Text text) {
                    VisitorSample.this.visit(text);
                }
            })
    );

    public void visit(Text text) {
        // This is called for all Text nodes. Override other visit methods for other node types.
        wordCount += text.getChars().unescape().split("\\W+").length;

        // Descending into children
        visitor.visitChildren(text);

        // Count words (this is just an example, don't actually do it this way for various reasons).
    }

    void countWords() {
        Parser parser = Parser.builder().build();
        Node document = parser.parse("Example\n=======\n\nSome more text");
        visitor.visit(document);

        System.out.println(wordCount);  // 4
    }
}
