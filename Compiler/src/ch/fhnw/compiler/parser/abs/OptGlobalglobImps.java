package ch.fhnw.compiler.parser.abs;

public class OptGlobalglobImps implements IAbs.IGlobImp{
	
	
	IGlobImp globImps;
	
	public  OptGlobalglobImps(IGlobImp glob) {
		// TODO Auto-generated constructor stub
		globImps=glob;
	}

	@Override
	public String toString(String indent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLine() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void check(Object routine) throws ContextError {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkInit() throws ContextError {
		// TODO Auto-generated method stub
		
	}

}
