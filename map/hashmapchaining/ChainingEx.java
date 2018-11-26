package map.hashmapchaining;

public class ChainingEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashDictionary<String,Integer> marks = new HashDictionary<String,Integer>();
		
		marks.put("Ceco", 6);
		marks.put("G", 5);
		marks.put("P", 2);
		marks.put("F", 4);
		marks.put("G", 3);
		
		for(DictionaryEntry<String,Integer> entry : marks) {
			System.out.println(entry + " ");
		}
		

	}

}
