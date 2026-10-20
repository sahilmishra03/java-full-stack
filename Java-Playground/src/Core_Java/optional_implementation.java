package Core_Java;

import java.util.Optional;

public class optional_implementation {
    static void main() {
        Optional<String> check = checkJobOffer("sahil");
        System.out.println(check.orElse("No Job Offer"));
    }

    static Optional<String> checkJobOffer(String name){
        if (name.startsWith("ani")){
            return Optional.of("Job Offer Granted");
        }else{
            return Optional.empty();
        }
    }
}
