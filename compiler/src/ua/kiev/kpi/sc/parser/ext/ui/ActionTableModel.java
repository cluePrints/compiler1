package ua.kiev.kpi.sc.parser.ext.ui;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import ua.kiev.kpi.sc.parser.ext.MyException;
import ua.kiev.kpi.sc.parser.node.Token;
import ua.kiev.kpi.sc.parser.parser.Parser;
import ua.kiev.kpi.sc.parser.parser.TokenIndex;

public class ActionTableModel extends AbstractTableModel{
	public static final String PREFFIX_ACCEPT = "ACCEPT";
	public static final String PREFFIX_ERROR = "e";
	public static final String PREFFIX_REDUCE = "r";
	public static final String PREFFIX_SHIFT = "s";
	private final int SHIFT = 0;
	private final int REDUCE = 1;
	private final int[][][] actionTable = Parser.actionTable;
	public final int TERMINAL_COUNT = getTerminalSymbolsCount();
	public final int NON_TERMINAL_COUNT = getNonTerminalSymbolsCount();	
	public final int STATES_COUNT = actionTable.length;
	
	private int getTerminalSymbolsCount()
	{
		int maxC = -1;
		for (int i=0; i<actionTable.length; i++) {
			for (int j=0; j<actionTable[i].length; j++) {
				int type = actionTable[i][j][1];
				if (type == SHIFT) {
					int terminal = actionTable[i][j][0];
					if (terminal>maxC) {
						maxC = terminal;
					}
				}
			}
		}
		return maxC+1;
	}
	
	private int getNonTerminalSymbolsCount()
	{
		int maxC = -1;
		for (int i=0; i<actionTable.length; i++) {
			for (int j=0; j<actionTable[i].length; j++) {
				int type = actionTable[i][j][1];
				if (type == REDUCE) {
					int terminal = actionTable[i][j][2];
					if (terminal>maxC) {
						maxC = terminal;
					}
				}
			}
		}
		return maxC+1;
	}
	
	
	public int getColumnCount() {
		return TERMINAL_COUNT + 1/*stateNum*/ + 1/*EOF terminal*/ /*+ NON_TERMINAL_COUNT*/;
	}

	
	public int getRowCount() {
		return STATES_COUNT;
	}

	
	public Object getValueAt(int rowIndex, int columnIndex) {
		int stateNum = rowIndex;
		if (columnIndex == 0) {	
			return stateNum;
		} else {
			if (columnIndex<=1+TERMINAL_COUNT+NON_TERMINAL_COUNT) {
				int terminalNum = columnIndex-1/*Number column*/ -1/*Any terminal column*/;
				int[][] actions = actionTable[stateNum];
				for (int i=0; i<actions.length; i++) {
					if (actions[i][0] == terminalNum) {
						int type = actions[i][1];
						if (type == Parser.SHIFT) {
							return PREFFIX_SHIFT+actions[i][2];
						} else if (type == Parser.REDUCE) {
							return PREFFIX_REDUCE+actions[i][2];
						} else if (type == Parser.ERROR) {
							return PREFFIX_ERROR+actions[i][2];
						} else if (type == Parser.ACCEPT) {
							return PREFFIX_ACCEPT;
						}
					}
				}
			}
		}
		return null;
	}
	public void applyColumnHeaders(TableColumnModel model) {
		List<String> headers = getColumnHeaders();
		for (int i=0; i<model.getColumnCount(); i++) {
			TableColumn col = model.getColumn(i);
			col.setHeaderValue(headers.get(i));
			col.setPreferredWidth(35);
		}
	}
	
	private TokenIndex indexer = new TokenIndex();
	public List<String> getColumnHeaders()
	{
		try {
			LinkedList<String> result = getTokenNamesIndexed();						
			result.add(0, "#state");
			result.add(1, "default");
			
			return result;
		} catch (Throwable th) {
			throw new MyException(th);
		}
	}

	LinkedList<String> getTokenNamesIndexed() {
		try {
			TreeMap<Integer, Class<?>> classToIdx = new TreeMap<Integer, Class<?>>();
			Class<?>[] classes = getClasses("ua.kiev.kpi.sc.parser.node");
			for (Class<?> clazz : classes) {
				if (Token.class.isAssignableFrom(clazz) && !Modifier.isAbstract(clazz.getModifiers())) {
					Constructor<?> c = clazz.getConstructors()[0];
					int paramCount = c.getParameterTypes().length;
					Object[] params = new Object[paramCount];
					Token t = (Token)c.newInstance(params);
					t.apply(indexer);
					Integer ind = indexer.index;
					classToIdx.put(ind, clazz);
				}
				
			}
			
			LinkedList<String> result = new LinkedList<String>();
			
			if (classToIdx.size() != 0) {
				for (int i=0; i<TERMINAL_COUNT; i++) {
					result.add(classToIdx.get(Integer.valueOf(i)).getSimpleName().substring(1)); 
				}
				result.add("EOF");
			} else {
				result.addAll(getTokenNamesOld());
			}
			
			return result;
		} catch (Throwable th) {
			throw new RuntimeException(th);
		}
	}
	
	private static List<String> getTokenNamesOld() 
	{
		List<String> lst = new LinkedList<String>(){{
			add("Comma");
			add("Dot");
			add("LBkt");
			add("LBrc");
			add("LPar");
			add("RBkt");
			add("RBrc");
			add("RPar");
			add("Semi");
			add("DoubleQuote");
			add("AmpAmp");
			add("Assign");
			add("BarBar");
			add("Emark");
			add("Eq");
			add("Gt");
			add("Gteq");
			add("Lt");
			add("Lteq");
			add("Minus");
			add("Neq");
			add("Percent");
			add("Plus");
			add("Slash");
			add("Star");
			add("Boolean");
			add("ClassToken");
			add("Else");
			add("Final");
			add("Float");
			add("For");
			add("If");
			add("Int");
			add("New");
			add("Public");
			add("Return");
			add("Short");
			add("Static");
			add("Void");
			add("While");
			add("StringToken");
			add("LiteralBoolean");
			add("LiteralNull");
			add("Identifier");
			add("NonNegativeInteger");
			add("Char");
			add("EOF");
			add("Comma");
			add("Dot");
			add("LBkt");
			add("LBrc");
			add("LPar");
			add("RBkt");
			add("RBrc");
			add("RPar");
			add("Semi");
			add("DoubleQuote");
			add("AmpAmp");
			add("Assign");
			add("BarBar");
			add("Emark");
			add("Eq");
			add("Gt");
			add("Gteq");
			add("Lt");
			add("Lteq");
			add("Minus");
			add("Neq");
			add("Percent");
			add("Plus");
			add("Slash");
			add("Star");
			add("Boolean");
			add("ClassToken");
			add("Else");
			add("Final");
			add("Float");
			add("For");
			add("If");
			add("Int");
			add("New");
			add("Public");
			add("Return");
			add("Short");
			add("Static");
			add("Void");
			add("While");
			add("StringToken");
			add("LiteralBoolean");
			add("LiteralNull");
			add("Identifier");
			add("NonNegativeInteger");
			add("Char");
			add("EOF");
		}};
		return lst;
	}
	
	private static Class[] getClasses(String packageName) {
		try{
			ClassLoader classLoader = Thread.currentThread()
					.getContextClassLoader();
			assert classLoader != null;
			String path = packageName.replace('.', '/');
			Enumeration<URL> resources = classLoader.getResources(path);
			List<File> dirs = new ArrayList<File>();
			while (resources.hasMoreElements()) {
				URL resource = resources.nextElement();
				dirs.add(new File(resource.getFile()));
			}
			ArrayList<Class> classes = new ArrayList<Class>();
			for (File directory : dirs) {
				classes.addAll(findClasses(directory, packageName));
			}
			return classes.toArray(new Class[classes.size()]);
		} catch (Throwable th) {
			throw new MyException(th);
		}
	}
	
	/**
     * Recursive method used to find all classes in a given directory and subdirs.
     *
     * @param directory   The base directory
     * @param packageName The package name for classes found inside the base directory
     * @return The classes
     * @throws ClassNotFoundException
     */
    private static List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
        List<Class> classes = new ArrayList<Class>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
            }
        }
        return classes;
    }


}
