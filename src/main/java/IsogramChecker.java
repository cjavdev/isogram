import java.util.*;
import java.util.stream.Collectors;

class IsogramChecker {

    boolean isIsogram(String phrase) {
        HashMap<Character, Integer> charCounter = new HashMap<Character, Integer>();

        for(char c : phrase.toLowerCase().toCharArray()) {
          if(c != '-' && c != ' ' && charCounter.containsKey(c)) {
            charCounter.put(c, 1 + charCounter.get(c));
          } else {
            charCounter.put(c, 1);
          }
        }

        return charCounter
          .entrySet()
          .stream()
          .filter(x -> x.getValue().intValue() > 1)
          .collect(Collectors.toList()).size() == 0;
    }

}
