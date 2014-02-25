package ko.konata.Objs;

import java.util.Comparator;

public class MyComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		ObjectPig p1=(ObjectPig)o1;
		ObjectPig p2=(ObjectPig)o2;  
       if(p1.spac > p2.spac)
           return 1;
       else
           return -1;
    }
}
