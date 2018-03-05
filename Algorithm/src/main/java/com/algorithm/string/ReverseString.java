package com.algorithm.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by mengtian on 2018/3/5
 */
public class ReverseString {

    public static class ReverseCollection<T> extends ArrayList<T> {
        public ReverseCollection(Collection<? extends T> c) {
            super(c);
        }

        @Override
        public Iterator<T> iterator() {
            return new Iterator<T>() {
                int currentSize = size() - 1;

                @Override
                public boolean hasNext() {
                    return currentSize > -1;
                }

                @Override
                public T next() {
                    return get(currentSize--);
                }
            };
        }
    }

    public static String reverseWords(String words) {
        ReverseCollection<String> reverseCollection = new ReverseCollection<>(Arrays.asList(words.split(" ")));
        StringBuilder builder = new StringBuilder();
        for (String word : reverseCollection) {
            builder.append(word + " ");
        }
        return builder.toString().trim();
    }

    public static void main(String[] args) {
        String words = "Hello World";
        System.out.println(reverseWords(words));
    }
}
