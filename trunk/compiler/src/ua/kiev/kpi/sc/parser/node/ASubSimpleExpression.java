/* This file was generated by SableCC (http://www.sablecc.org/). */

package ua.kiev.kpi.sc.parser.node;

import ua.kiev.kpi.sc.parser.analysis.*;

@SuppressWarnings("nls")
public final class ASubSimpleExpression extends PSimpleExpression
{
    private PSummand _summand_;
    private TMinus _minus_;
    private PSimpleExpression _simpleExpression_;

    public ASubSimpleExpression()
    {
        // Constructor
    }

    public ASubSimpleExpression(
        @SuppressWarnings("hiding") PSummand _summand_,
        @SuppressWarnings("hiding") TMinus _minus_,
        @SuppressWarnings("hiding") PSimpleExpression _simpleExpression_)
    {
        // Constructor
        setSummand(_summand_);

        setMinus(_minus_);

        setSimpleExpression(_simpleExpression_);

    }

    @Override
    public Object clone()
    {
        return new ASubSimpleExpression(
            cloneNode(this._summand_),
            cloneNode(this._minus_),
            cloneNode(this._simpleExpression_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseASubSimpleExpression(this);
    }

    public PSummand getSummand()
    {
        return this._summand_;
    }

    public void setSummand(PSummand node)
    {
        if(this._summand_ != null)
        {
            this._summand_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._summand_ = node;
    }

    public TMinus getMinus()
    {
        return this._minus_;
    }

    public void setMinus(TMinus node)
    {
        if(this._minus_ != null)
        {
            this._minus_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._minus_ = node;
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
            + toString(this._summand_)
            + toString(this._minus_)
            + toString(this._simpleExpression_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._summand_ == child)
        {
            this._summand_ = null;
            return;
        }

        if(this._minus_ == child)
        {
            this._minus_ = null;
            return;
        }

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
        if(this._summand_ == oldChild)
        {
            setSummand((PSummand) newChild);
            return;
        }

        if(this._minus_ == oldChild)
        {
            setMinus((TMinus) newChild);
            return;
        }

        if(this._simpleExpression_ == oldChild)
        {
            setSimpleExpression((PSimpleExpression) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}