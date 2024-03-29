/* This file was generated by SableCC (http://www.sablecc.org/). */

package ua.kiev.kpi.sc.parser.node;

import ua.kiev.kpi.sc.parser.analysis.*;

@SuppressWarnings("nls")
public final class ASimpleComparisonExpression extends PComparisonExpression
{
    private PSimpleExpression _simpleExpression_;

    public ASimpleComparisonExpression()
    {
        // Constructor
    }

    public ASimpleComparisonExpression(
        @SuppressWarnings("hiding") PSimpleExpression _simpleExpression_)
    {
        // Constructor
        setSimpleExpression(_simpleExpression_);

    }

    @Override
    public Object clone()
    {
        return new ASimpleComparisonExpression(
            cloneNode(this._simpleExpression_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseASimpleComparisonExpression(this);
    }

    public PSimpleExpression getSimpleExpression()
    {
        return this._simpleExpression_;
    }

    public void setSimpleExpression(PSimpleExpression node)
    {
        if(this._simpleExpression_ != null)
        {
            this._simpleExpression_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._simpleExpression_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._simpleExpression_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._simpleExpression_ == child)
        {
            this._simpleExpression_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._simpleExpression_ == oldChild)
        {
            setSimpleExpression((PSimpleExpression) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
