
package Core_Java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

record NetflixTitle(
        String name,
        String genre,
        double rating,
        boolean alreadyWatched,
        int runTimeInMins
) {}

public class stream_api_implementation {

    public static void main(String[] args) {

        List<NetflixTitle> catalog = List.of(
                new NetflixTitle("Inception", "Action", 4.9,
                        false, 148),

                new NetflixTitle("Interstellar", "Sci-Fi", 4.8,
                        false, 169),

                new NetflixTitle("Dark", "Sci-Fi", 4.7,
                        true, 60),

                new NetflixTitle("Dune: Part Two", "Action", 4.8,
                        false, 166),

                new NetflixTitle("The Office", "Comedy", 4.7,
                        false, 22),

                new NetflixTitle("Spider-Man: Across the Spider-Verse",
                        "Action", 4.9, false, 140),

                new NetflixTitle("Oppenheimer", "Drama", 4.9,
                        false, 180),

                new NetflixTitle("Stranger Things", "Sci-Fi", 4.8,
                        true, 50)
        );

        Set<String> set = Set.of("Action", "Sci-Fi");

        List<String> recommendations = catalog.stream()
                .filter(title -> set.contains(title.genre()))
                .filter(title -> !title.alreadyWatched())
                .filter(title -> title.rating() > 4.5)
                .filter(title -> title.runTimeInMins() >= 150)
                .sorted(Comparator.comparingDouble(
                        NetflixTitle::rating
                ).reversed())
                .map(NetflixTitle::name)
                .limit(3)
                .toList();

//        recommendations.forEach(System.out::println);

        List<String> unwatched =  catalog.stream()
                .filter(netflixTitle -> netflixTitle.genre().equals("Sci-Fi"))
                .filter(title -> !title.alreadyWatched())
                .map(NetflixTitle::name)
                .toList();

        unwatched.forEach(System.out::println);

//        List<Integer> nums = Arrays.asList(5, 12, 8, 21, 14, 3, 12);
//        List<Integer> res = nums.stream()
//                .filter(num->num>10)
//                .toList();

//        res.forEach(System.out::println);

        List<Integer> nums = Arrays.asList(5, 12, 8, 21, 14, 3, 12);
        List<Integer> res = nums.stream()
                .filter(num->num%2==0)
                .map(num->num*num)
                .toList();

        res.forEach(System.out::println);
    }
}
