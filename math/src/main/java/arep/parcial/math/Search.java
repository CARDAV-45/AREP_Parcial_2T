package arep.parcial.math;

public class Search {

    public static int binarySearch(int[] arr, int target, int izq, int der) {
        if (izq > der) {
            return -1;
        }
    
        int mit = (izq + der) / 2;
    
        if (arr[mit] == target) {
            return mit;
        }
    
        if (target < arr[mit]) {
            return binarySearch(arr, target, izq, mit - 1);
        }
    
        return binarySearch(arr, target, mit + 1, der);
    }

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int[] parseArray(String arrStr) {
        String[] parts = arrStr.split(",");
        int[] arr = new int[parts.length];
    
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i].trim());
        }
    
        return arr;
    }
}
