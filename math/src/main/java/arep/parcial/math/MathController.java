package arep.parcial.math;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @GetMapping("/search")
    public String search(@RequestParam(value = "value") int value,
            @RequestParam(value = "arr") String arrStr) {
        int[] arr = Search.parseArray(arrStr);
        int result = Search.binarySearch(arr, value, 0, arr.length - 1);
        return "Output: " + result;
    }
}