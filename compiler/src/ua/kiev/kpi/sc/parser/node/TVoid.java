/* This file was generated by SableCC (http://www.sablecc.org/). */

package ua.kiev.kpi.sc.parser.node;

import ua.kiev.kpi.sc.parser.analysis.*;

@SuppressWarnings("nls")
public final class TVoid extends Token
{
    public TVoid()
    {
        super.setText("void");
    }

    public TVoid(int line, int pos)
    {
        super.setText("void");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TVoid(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTVoid(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TVoid text.");
    }
}
