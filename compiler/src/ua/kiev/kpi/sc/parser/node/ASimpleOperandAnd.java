/* This file was generated by SableCC (http://www.sablecc.org/). */

package ua.kiev.kpi.sc.parser.node;

import ua.kiev.kpi.sc.parser.analysis.*;

@SuppressWarnings("nls")
public final class ASimpleOperandAnd extends POperandAnd
{
    private PComparisonExpression _comparisonExpression_;

    public ASimpleOperandAnd()
    {
        // Constructor
    }

    public ASimpleOperandAnd(
        @SuppressWarnings("hiding") PComparisonExpression _comparisonExpression_)
    {
        // Constructor
        setComparisonExpression(_comparisonExpression_);

    }

    @Override
    public Object clone()
    {
        return new ASimpleOperandAnd(
            cloneNode(this._comparisonExpression_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseASimpleOperandAnd(this);
    }

    public PComparisonExpression getComparisonExpression()
    {
        return this._comparisonExpression_;
    }

    public void setComparisonExpression(PComparisonExpression node)
    {
        if(this._comparisonExpression_ != null)
        {
            this._comparisonExpression_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._comparisonExpression_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._comparisonExpression_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._comparisonExpression_ == child)
        {
            this._comparisonExpression_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._comparisonExpression_ == oldChild)
        {
            setComparisonExpression((PComparisonExpression) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}