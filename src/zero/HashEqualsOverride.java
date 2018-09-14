package zero;

public class HashEqualsOverride {

	
		private int num;
			private String data;
	
			public boolean equals(Object obj)
			{
				if(this == obj)
					return true;
				if((obj == null) || (obj.getClass() != this.getClass()))
					return false;
				// object must be Test at this point
		HashEqualsOverride test = (HashEqualsOverride) obj;
		return num == test.num &&
				(data == test.data || (data != null && data.equals(test.data)));
			}
	
			public int hashCode()
			{
				int hash = 7;
				hash = 31 * hash + num;
				hash = 31 * hash + (null == data ? 0 : data.hashCode());
				return hash;
			}
			
			public static void main(String[] args) {
				HashEqualsOverride ob1 = new HashEqualsOverride();
				HashEqualsOverride ob2 = new HashEqualsOverride();
				System.out.println(ob1.equals(ob2));
				System.out.println(ob1.hashCode());
				System.out.println(ob2.hashCode());
			}
	
			// other methods
		}
