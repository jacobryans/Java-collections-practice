package collections;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Initialize array shortcut
        Dogs dogArray[] = new Dogs[5];

        System.out.println();

        //Array stuff

        System.out.println("*** Array ***");

        dogArray[0] = new Dogs("Boxer", 25, false);
        dogArray[1] = new Dogs("Chihuahua", 5, true);
        dogArray[2] = new Dogs("Bulldog", 50, true);
        dogArray[3] = new Dogs("Daschund", 10, true);
        dogArray[4] = new Dogs("Catahoula Curr", 40, false);

        for(int i = 0; i < dogArray.length; i++) {
            System.out.println(dogArray[i]);
        }

        System.out.println(Arrays.toString(dogArray));
        System.out.println();

        System.out.println("*** Array List ***");
        ArrayList<Dogs> dogArrayList = new ArrayList<Dogs>();
        dogArrayList.addAll(Arrays.asList(dogArray));

        for(Dogs d : dogArrayList) {
            System.out.println(d);
        }

        System.out.println();

        dogArrayList.add(5, new Dogs("Labrador", 75, false));
        dogArrayList.forEach(d -> System.out.println(d));

        Iterator<Dogs> iterator = dogArrayList.iterator();

        System.out.println();



        while(iterator.hasNext()) {
            Dogs tempDog = iterator.next();
            String result = (tempDog.isApartment()) ? "is good for apartments." : "isn't good for apartments.";
            if(!tempDog.isApartment()) {
                iterator.remove();
                System.out.println("* " + tempDog.getBreed() + " removed from array list.");
            }
            System.out.println("A " + tempDog.getBreed() + " " + result);
        }

        Collections.sort(dogArrayList, new Comparator<Dogs>() {
            public int compare(Dogs o1, Dogs o2) {
                return o1.getBreed().compareToIgnoreCase(o2.getBreed());
            }
        });

        Collections.sort(dogArrayList, new Comparator<Dogs>() {
            public int compare(Dogs o1, Dogs o2) {
                return o2.getAvgWeight() - o1.getAvgWeight();
            }
        });

        System.out.println();
        System.out.println("*** HashMap ***");

        HashMap<Integer, Dogs> dogHashMap = new HashMap<Integer, Dogs>();

        int count = 0;

        for(Dogs d : dogArrayList) {
            dogHashMap.put(count, d);
            count++;
        }

        dogArrayList.clear();

        for(Integer i : dogHashMap.keySet()){
            System.out.println(dogHashMap.get(i));
        }

        System.out.println();
        dogHashMap.remove(3);
        System.out.println();

        for(Integer i : dogHashMap.keySet()){
            System.out.println(dogHashMap.get(i));
        }

        ArrayList<HashMap.Entry<Integer, Dogs>> sortedMap = new ArrayList<HashMap.Entry<Integer, Dogs>>();
        sortedMap.addAll(dogHashMap.entrySet());

        Collections.sort(sortedMap, new Comparator<Map.Entry<Integer, Dogs> >()
        {
            public int compare (HashMap.Entry<Integer, Dogs> o1, HashMap.Entry<Integer, Dogs> o2)
            {
                return o1.getValue().getAvgWeight() - o2.getValue().getAvgWeight();
            }
        });

        System.out.println();
        System.out.println("*** Sorted HashMap ***");
        sortedMap.forEach(d -> System.out.println(d));

    }
}