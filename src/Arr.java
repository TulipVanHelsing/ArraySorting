import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JOptionPane;

public class Arr {
	
	int[] creat (String size, int init) {
		try {
			Integer.parseInt(size);
		}catch (NumberFormatException e) {
			size = "1";
		}
		
		int[] array = new int[Integer.parseInt(size)];
		//при ручном заполнении
		if(init == 0) {
			for(int i = 0; i < array.length; i++) {
				try {
					array[i] = Integer.parseInt(JOptionPane.showInputDialog("Ёлемент номер ["+i+"]","¬ведите число"));
				} catch (NumberFormatException e) {
					array[i] = 0;
				}
			}
		}
		
		//при случайном заполнении
		if(init == 1) {
			for(int i = 0; i < array.length; i++) {
				array[i] = ThreadLocalRandom.current().nextInt(-999, 999 + 1);
			}
		}
		
		return array;
	}
	
	int[][] creat (String sizeX, String sizeY, int init){
		try {
			Integer.parseInt(sizeX);
		}catch (NumberFormatException e) {
			sizeX = "1";
		}
		try {
			Integer.parseInt(sizeY);
		}catch (NumberFormatException e) {
			sizeY = "1";
		}
		
		int[][] array = new int[Integer.parseInt(sizeX)][Integer.parseInt(sizeY)];
		//при ручном заполнении
		if(init == 0){
			for(int i = 0; i < array.length; i++) {
				for(int j = 0; j< array[0].length; j++) {
					try {
						array[i][j] = Integer.parseInt(
								JOptionPane.showInputDialog("Ёлемент ["+i+"]["+j+"]","¬ведите число"));
					}catch(NumberFormatException e){
						array[i][j] = 0;
					}
					
				}
			}
		}
		//при случайном заполнении
		if(init == 1) {
			for(int i = 0; i < Integer.parseInt(sizeX); i++) {
				for(int j = 0; j< Integer.parseInt(sizeY); j++) {
					array[i][j] = ThreadLocalRandom.current().nextInt(-999, 999 + 1);
				}
			}
		}
		return array;
	}
	
	int[] sortStupid (int array[]) {
		int i = 0;
		while (true) {
			if(i == array.length-1) {
				break;
			}
			if(array[i] > array[i+1]) {
				swap(array, i, i+1);
				i = 0;
			}else {
				i++;
			}
		}
		return array;
	}
	
	int[][] sortStupid (int array[][]){
		int[] planeArray = new int[array.length*array[0].length];
		int iPlane;
		
		//turn 2d array into 1d
		iPlane = 0;
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[0].length; j++) {
				planeArray[iPlane++] = array[i][j];
			}
		}
		
		sortStupid(planeArray);
		
		//turn 1d array into 2d back
		iPlane = 0;
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[0].length; j++) {
				array[i][j] = planeArray[iPlane++];
			}
		}
		return array;
	}
	
	int[] sortBouse (int array[]) {
		int[] buffer1 = Arrays.copyOf(array, array.length);
        int[] buffer2 = new int[array.length];
        int[] result = mergesortInner(buffer1, buffer2, 0, array.length);
        return result;
	}
	
	int[][] sortBouse (int array[][]) {
		int[] planeArray = new int[array.length*array[0].length];
		int iPlane;
		
		//turn 2d array into 1d
		iPlane = 0;
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[0].length; j++) {
				planeArray[iPlane++] = array[i][j];
			}
		}
		
		planeArray = sortBouse(planeArray);
		
		//turn 1d array into 2d back
		iPlane = 0;
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[0].length; j++) {
				array[i][j] = planeArray[iPlane++];
			}
		}
		return array;
	}
	
	void swap (int array[], int a,int b) {
		array[a] = array[a] + array[b];
		array[b] = array[a] - array[b];
		array[a] = array[a] - array[b];
	}
	
	int[] mergesortInner(int[] buffer1, int[] buffer2,
            int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return buffer1;
        }
        
        // уже отсортирован.
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergesortInner(buffer1, buffer2, startIndex, middle);
        int[] sorted2 = mergesortInner(buffer1, buffer2, middle, endIndex);
        
        // —ли€ние
        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }
	
	public static String println2DArray (int newArray[][]) {
		String output = "";
		for (int i = 0; i < newArray.length; i++) {
		    output += Arrays.toString(newArray[i]) + "\n";
		}
		return output;
	}
}