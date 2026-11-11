package exercise;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import model.Post;
import model.User;

public class Sorting {

    /**
     * Returns a new List with the Post objects in the given list sorted by their
     * publishedAt date in ascending order (oldest first).
     *
     * This method does not modify the given list.
     *
     * @param posts list of posts to sort
     * @return a new list of posts sorted by their published date in ascending order
     */
    public static List<Post> sortPostsByPublishedDate(List<Post> posts) {

        List<Post> sortedPosts = new ArrayList<>(posts);
        
            boolean vaihtettu = true;

            while (vaihtettu) {
                vaihtettu = false;
                
           

           for (int i = 0; i < sortedPosts.size() - 1; i++) {

                Post eka = sortedPosts.get(i);
                Post toka = sortedPosts.get(i + 1);

                if (eka.publishedAt().compareTo(toka.publishedAt()) >0 ) {
                    sortedPosts.set(i, toka);
                    sortedPosts.set(i+1, eka);
                     vaihtettu = true;

                    
                }

                
            }
        }
            


        return sortedPosts; // TODO: return a new list with the posts sorted
    }

    /**
     * Returns a new list with the given users sorted by their registration date in
     * ascending order (oldest first).
     *
     * This method does not modify the given list.
     *
     * @param users list of users to sort
     * @return a new list of users sorted by their registration date
     */
    public static List<User> sortUsersByRegistrationDate(List<User> users) {
        List<User> sortedUsers = new  ArrayList<>(users);

        sortedUsers.sort((user1, user2) -> {

            String date1 = user1.registeredAt();
            String date2 = user2.registeredAt();


            long time1;
            long time2;

            if (date1.contains("T")){
                time1 = Instant.parse(date1).getEpochSecond();
            }
            else
            {
                time1 = Long.parseLong(date1);

            }  if (date2.contains("T")) {
                time2 = Instant.parse(date2).getEpochSecond();
                
            }else{
                time2 = Long.parseLong(date2);


            }
            return Long.compare(time1, time2);

        });

        /*
         * Note that each User can have different data types for `registeredAt` field:
         * - numeric (seconds since epoch), for example "1632225600"
         * - string (ISO 8601), for example "2021-09-21T12:00:00Z"
         *
         * This time a simple alphabetical ordering of the string values is not enough.
         */
        return sortedUsers; // TODO: You are allowed to use existing implementations.
    }
}
