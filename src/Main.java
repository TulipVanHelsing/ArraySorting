import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		
		//declaration
		int type;
		int init;
		int method;
		int arr1[] = null;
		int arr2[][] = null;
		String size = null;
		String dimX = null;
		String dimY = null;
		String[] responsisToType = {"Одномерный массив","Двухмерная матрица"};
		String[] responsisToSort = {"Глупая сортировка","Прямое слияние Боуза-Нельсона"};
		ImageIcon icon = new ImageIcon("organization.jpg");
		Arr newArray = new Arr();
		
		while(true) {
			//0 for 1d
			//1 for 2d
			//-1 for exit
			type = JOptionPane.showOptionDialog(
					null,
					"Какой тип массива",
					"Тип",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,
					responsisToType,
					0);
			if (type == -1) {
				break;
			}
			//1d array size
			if(type == 0) {
				size = JOptionPane.showInputDialog("Введите размерность массива");
				if(size == null) {
					break;
				}
			}
			//2d array size
			if(type == 1) {
				dimX =JOptionPane.showInputDialog("Сколько столбцов матрицы");
				if(dimX == null) {
					break;
				}
				dimY =JOptionPane.showInputDialog("Сколько строк матрицы");
				if(dimY == null) {
					break;
				}
			}
			
			//0 for manual
			//1 for random
			//-1 for exit
			init = JOptionPane.showConfirmDialog(
					null, 
					"Заполнить массив в ручную?", 
					"Заполнение", 
					JOptionPane.YES_NO_OPTION, 
					JOptionPane.QUESTION_MESSAGE);
			if (init == -1) {
				break;
			}
			
			
			//1d array init
			if(type == 0) {
				arr1 = newArray.creat(size, init);
				JOptionPane.showMessageDialog(
						null, 
						Arrays.toString(arr1), 
						"Массив", 
						JOptionPane.PLAIN_MESSAGE);
			}
			//2d array init
			if(type == 1) {
				arr2 = newArray.creat(dimX, dimY, init);
				JOptionPane.showMessageDialog(
						null,
						Arr.println2DArray(arr2),
						"Матрица",
						JOptionPane.PLAIN_MESSAGE);
			}
			
			//0 for Глупая
			//1 for Bouse-Nelson
			//-1 for exit
			method = JOptionPane.showOptionDialog(
					null, 
					"Какой метод сортировки использовать?", 
					"Выбор метода", 
					JOptionPane.YES_NO_CANCEL_OPTION, 
					JOptionPane.QUESTION_MESSAGE, 
					icon, 
					responsisToSort,
					0);
			if (method == -1) {
				break;
			}
			
			//1d array sort
			if(type == 0) {
				switch(method) {
				case 0:
					JOptionPane.showMessageDialog(
							null, 
							Arrays.toString(newArray.sortStupid(arr1)),
							"Отсортировано",
							JOptionPane.PLAIN_MESSAGE);
					break;
				case 1:
					JOptionPane.showMessageDialog(
							null, 
							Arrays.toString(newArray.sortBouse(arr1)),
							"Отсортировано",
							JOptionPane.PLAIN_MESSAGE);
					break;
				}
			} 
			//2d array sort
			if(type == 1) {
				switch(method) {
				case 0:
					JOptionPane.showMessageDialog(
							null, 
							Arr.println2DArray(newArray.sortStupid(arr2)),
							"Отсортировано",
							JOptionPane.PLAIN_MESSAGE);
					break;
				case 1:
					JOptionPane.showMessageDialog(
							null, 
							Arr.println2DArray(newArray.sortBouse(arr2)),
							"Отсортировано",
							JOptionPane.PLAIN_MESSAGE);
					break;
				}
			}
			
		}
		
	}

}
