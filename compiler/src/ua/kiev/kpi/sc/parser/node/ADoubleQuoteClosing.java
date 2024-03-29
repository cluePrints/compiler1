/* This file was generated by SableCC (http://www.sablecc.org/). */

package ua.kiev.kpi.sc.parser.node;

import ua.kiev.kpi.sc.parser.analysis.*;

@SuppressWarnings("nls")
public final class ADoubleQuoteClosing extends PDoubleQuoteClosing
{
    private TDoubleQuote _doubleQuote_;

    public ADoubleQuoteClosing()
    {
        // Constructor
    }

    public ADoubleQuoteClosing(
        @SuppressWarnings("hiding") TDoubleQuote _doubleQuote_)
    {
        // Constructor
        setDoubleQuote(_doubleQuote_);

    }

    @Override
    public Object clone()
    {
        return new ADoubleQuoteClosing(
            cloneNode(this._doubleQuote_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseADoubleQuoteClosing(this);
    }

    public TDoubleQuote getDoubleQuote()
    {
        return this._doubleQuote_;
    }

    public void setDoubleQuote(TDoubleQuote node)
    {
        if(this._doubleQuote_ != null)
        {
            this._doubleQuote_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._doubleQuote_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._doubleQuote_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._doubleQuote_ == child)
        {
            this._doubleQuote_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._doubleQuote_ == oldChild)
        {
            setDoubleQuote((TDoubleQuote) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
