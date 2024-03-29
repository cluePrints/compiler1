/* This file was generated by SableCC (http://www.sablecc.org/). */

package ua.kiev.kpi.sc.parser.node;

import ua.kiev.kpi.sc.parser.analysis.*;

@SuppressWarnings("nls")
public final class AVariableResultType extends PResultType
{
    private PVariableType _variableType_;

    public AVariableResultType()
    {
        // Constructor
    }

    public AVariableResultType(
        @SuppressWarnings("hiding") PVariableType _variableType_)
    {
        // Constructor
        setVariableType(_variableType_);

    }

    @Override
    public Object clone()
    {
        return new AVariableResultType(
            cloneNode(this._variableType_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAVariableResultType(this);
    }

    public PVariableType getVariableType()
    {
        return this._variableType_;
    }

    public void setVariableType(PVariableType node)
    {
        if(this._variableType_ != null)
        {
            this._variableType_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._variableType_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._variableType_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._variableType_ == child)
        {
            this._variableType_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._variableType_ == oldChild)
        {
            setVariableType((PVariableType) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
