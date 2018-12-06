package com.algorithm.praveen.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;

public class WikiQuestionAnswers {

    /*static String TEXT = "I work in technology like java and micro-service. Hello My name is Praveen. I live in city of Bangalore";
    static String QUESTIONS = "Which city do you live? Which technology do you work? What is your name?";
    static String ANSWERS = "Praveen, Bangalore, java and micro-service";*/

    static String TEXT = "Zebras are several species of African equids (horse family) united by their distinctive black and white stripes. Their stripes come in different patterns, unique to each individual. They are generally social animals that live in small harems to large herds. Unlike their closest relatives, horses and donkeys, zebras have never been truly domesticated. There are three species of zebras: the plains zebra, the Grévy's zebra and the mountain zebra. The plains zebra and the mountain zebra belong to the subgenus Hippotigris, but Grévy's zebra is the sole species of subgenus Dolichohippus. The latter resembles an ass, to which it is closely related, while the former two are more horse-like. All three belong to the genus Equus, along with other living equids. The unique stripes of zebras make them one of the animals most familiar to people. They occur in a variety of habitats, such as grasslands, savannas, woodlands, thorny scrublands, mountains, and coastal hills. However, various anthropogenic factors have had a severe impact on zebra populations, in particular hunting for skins and habitat destruction. Grévy's zebra and the mountain zebra are endangered. While plains zebras are much more plentiful, one subspecies - the Quagga - became extinct in the late 19th century. Though there is currently a plan, called the Quagga Project, that aims to breed zebras that are phenotypically similar to the Quagga, in a process called breeding back.";
    static String QUESTIONS = "Which Zebras are endangered? What is the aim of the Quagga Project? Which animals are some of their closest relatives? Which are the three species of zebras? Which subgenus do the plains zebra and the mountain zebra belong to?";
    static String ANSWERS = "subgenus Hippotigris; the plains zebra, the Grévy's zebra and the mountain zebra;horses and donkeys;aims to breed zebras that are phenotypically similar to the quagga; Grévy's zebra and the mountain zebra";


    static String[] questions = null;
    static String[] answers = null;
    static String[] sentences = null;
    static List<String> excludeWords = Arrays.asList("is", "the", "of", "a", "in", "are", "and");

    static {
        sentences = TEXT.split("\\.");
        questions = QUESTIONS.split("\\?");
        answers = ANSWERS.split(";");

        System.out.println("Sentences....");
        for(String sentence : sentences) {
            System.out.println(sentence);
        }

        System.out.println("Questions....");
        for(String question : questions) {
            System.out.println(question);
        }

        System.out.println("Answers....");
        for(String answer : answers) {
            System.out.println(answer);
        }
    }


    public static void main(String[] args) {
        Map<Integer, Map<String, Integer>> sentenceWordCountMaps = getSentenceToWordCountMap(TEXT, ".");
        Map<Integer, Map<String, Integer>> questionsWordCountMaps = getSentenceToWordCountMap(QUESTIONS, "?");
        Map<Integer, Map<String, Integer>> answersWordCountMaps = getSentenceToWordCountMap(ANSWERS, ";");

        System.out.println("sentenceWordCountMaps "+ sentenceWordCountMaps);
        System.out.println("questionsWordCountMaps "+ questionsWordCountMaps);
        System.out.println("answersWordCountMaps "+ answersWordCountMaps);

        getAnswersForQuestions(sentenceWordCountMaps, questionsWordCountMaps, answersWordCountMaps);
    }


/*
    public static void main(String[] args) {
        System.out.println("(,print)".replaceAll(",|\\)|\\(",""));
    }
*/
    private static Map<Integer, Integer> getAnswersForQuestions(Map<Integer, Map<String, Integer>> sentenceWordCountMaps, Map<Integer, Map<String, Integer>> questionsWordCountMaps, Map<Integer, Map<String, Integer>> answersWordCountMaps) {
        Map<Integer, List<Integer>> questionToSentenceMap = new HashMap<>();
        Map<Integer, List<Integer>> answerToSentenceMap = new HashMap<>();
        questionsWordCountMaps.forEach(getSentenceForGivenQuestion(sentenceWordCountMaps, questionToSentenceMap));
        System.out.println("$$$");
        answersWordCountMaps.forEach(getSentenceForGivenAnswers(sentenceWordCountMaps, answerToSentenceMap));

        System.out.println("questionToSentenceMap: "+questionToSentenceMap);
        System.out.println("answerToSentenceMap: "+answerToSentenceMap);
        return getAnswerForEachQuestion(questionToSentenceMap, answerToSentenceMap);
    }

    private static Map<Integer, Integer> getAnswerForEachQuestion(Map<Integer, List<Integer>> questionToSentenceMap, Map<Integer, List<Integer>> answerToSentenceMap) {
        System.out.println("Answers #####");
        Map<Integer, Integer> questionToAnswerMap = new HashMap<>();
        for(Map.Entry<Integer, List<Integer>> questionToSentenceEntry: questionToSentenceMap.entrySet()) {
            for(Map.Entry<Integer, List<Integer>> answerToSentenceMapEntry: answerToSentenceMap.entrySet()) {
                if(bothListsHaveOneElementAndSameValue(questionToSentenceEntry.getValue(), answerToSentenceMapEntry.getValue())) {
                    System.out.println(questionToSentenceEntry.getKey() + ": " + answerToSentenceMapEntry.getKey());
                    System.out.println(questions[questionToSentenceEntry.getKey()] + ": "+answers[answerToSentenceMapEntry.getKey()]);
                    questionToAnswerMap.put(questionToSentenceEntry.getKey(), answerToSentenceMapEntry.getKey());
                    break;
                } else if(questionToSentenceEntry.getValue().size() > 1 || answerToSentenceMapEntry.getValue().size() > 1){
                    Integer index = getCommonElement(questionToSentenceEntry.getValue(), answerToSentenceMapEntry.getValue());
                    if(null != index) {
                        System.out.println(questions[questionToSentenceEntry.getKey()] + ": "+sentences[index]);
                        questionToAnswerMap.put(questionToSentenceEntry.getKey(), answerToSentenceMapEntry.getKey());
                        break;
                    }
                }
            }
        }
        return questionToAnswerMap;
    }

    private static boolean bothListsHaveOneElementAndSameValue(List<Integer> questionToSentenceList, List<Integer> answerToSentenceList) {
        return (questionToSentenceList.size() == 1 && answerToSentenceList.size() == 1)
                &&
                questionToSentenceList.get(0) == answerToSentenceList.get(0);
    }

    private static Integer getCommonElement(List<Integer> list1, List<Integer> list2) {
        List<Integer> commonElements = new ArrayList<>();
        for(Integer element1:list1) {
            if(list2.contains(element1)) {
                commonElements.add(element1);
            }
        }
        return commonElements.isEmpty() ? null : commonElements.get(0);
    }

    private static BiConsumer<? super Integer,? super Map<String,Integer>> getSentenceForGivenAnswers(Map<Integer, Map<String, Integer>> sentenceWordCountMaps, Map<Integer, List<Integer>> answerToSentenceMap) {
        return getSentenceForGivenQuestion(sentenceWordCountMaps, answerToSentenceMap);
    }

    private static BiConsumer<? super Integer,? super Map<String,Integer>> getSentenceForGivenQuestion(Map<Integer, Map<String, Integer>> sentenceWordCountMaps, Map<Integer, List<Integer>> questionToSentenceMap) {
        AtomicInteger maxMatch = new AtomicInteger(0);
        AtomicInteger maxMatchIndex = new AtomicInteger(0);
        return (questionIndex, questionWordCountFrequency) -> {
            if(questionIndex == 1){

            }
            List<Integer> matchedSentences = null;
            for(Map.Entry<Integer, Map<String, Integer>> entry: sentenceWordCountMaps.entrySet()){

                int matchedWords = getCommonWords(questionWordCountFrequency, entry.getValue());
                if(matchedWords > 0) {
                    //System.out.println(matchedWords);
                }
                if(matchedWords > maxMatch.get()) {
                    maxMatch.set(matchedWords);
                    maxMatchIndex.set(entry.getKey());
                    matchedSentences = new ArrayList<>();
                    matchedSentences.add(maxMatchIndex.get());
                } else if(matchedWords == maxMatch.get()) {
                    maxMatch.set(matchedWords);
                    maxMatchIndex.set(entry.getKey());
                    //matchedSentences = questionToSentenceMap.get(questionIndex);
                    if(null == matchedSentences) {
                        matchedSentences = new ArrayList<>();
                    }
                    matchedSentences.add(maxMatchIndex.get());
                }
            }
            questionToSentenceMap.put(questionIndex, matchedSentences);
            maxMatchIndex.set(0);
            maxMatch.set(0);
        };
    }

    private static int getCommonWords(Map<String, Integer> map1, Map<String, Integer> map2) {
        int commonWords = 0;
        String word = null;

        for(Map.Entry<String,Integer> map1EntrySet: map1.entrySet()) {
            word = map1EntrySet.getKey();
            Integer count = getMatchingWordsCount(word, map2);
            if(null != count && count > 0){
                //System.out.println("    "+map1EntrySet.getKey());
                commonWords++;
            }
        }
        if(commonWords > 0){
            //System.out.println("CommonWords: ");
        }
        return commonWords;
    }

    private static Map<Integer, Map<String, Integer>> getSentenceToWordCountMap(String text, String delimiter) {
        StringTokenizer st = new StringTokenizer(text, delimiter);
        int numberOfSentences = st.countTokens();
        String[] sentences = new String[numberOfSentences];
        String sentence = null;
        Map<Integer, Map<String, Integer>> sentenceWordCountMaps = new HashMap<>();
        Map<String, Integer> sentenceWordCountMap = null;

        Integer index = 0;
        while(st.hasMoreTokens()) {
            sentence = st.nextToken();
            sentenceWordCountMap = calculateWordFrequency(sentence);
            sentenceWordCountMaps.put(index, sentenceWordCountMap);
            index++;
        }

        printSentenceWordCountMaps(sentenceWordCountMaps);
        return sentenceWordCountMaps;
    }

    private static void printSentenceWordCountMaps(Map<Integer, Map<String, Integer>> sentenceWordCountMaps) {
        System.out.println("-------------------");
        sentenceWordCountMaps.forEach( (index, wordCountMap)->{
            //System.out.println(index);
            wordCountMap.forEach((word, count) -> {
                //System.out.println(word + ":" + count);
            });
            //System.out.println("-------------------");
        });
    }

    private static Map<String,Integer> calculateWordFrequency(String sentence) {
        Map<String, Integer> sentenceWordCountMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(sentence, " ");
        String word = null;
        Integer count = 0;
        while (st.hasMoreTokens()) {
            word = st.nextToken();
            word = word.toLowerCase();
            word = word.replaceAll(",|\\(|\\)","");
            if(excludeWords.contains(word)) {
                continue;
            }

            count = getMatchingWordsCount(word,sentenceWordCountMap);
            if(count == null) {
                count = 1;
            } else {
                count++;
            }
            sentenceWordCountMap.put(word, count);
        }
        return sentenceWordCountMap;
    }

    private static Integer getMatchingWordsCount(String word, Map<String, Integer> sentenceWordCountMap) {
        int cnt1 = sentenceWordCountMap.get(word)==null ? 0 : sentenceWordCountMap.get(word);
        int cnt2 = sentenceWordCountMap.get(word+"s")==null ? 0 : sentenceWordCountMap.get(word+"s");
        int cnt3 = 0;
        if(word.endsWith("s")) {
            cnt3 = sentenceWordCountMap.get(word.substring(0,word.length()-1)) == null ? 0 : sentenceWordCountMap.get(word.substring(0, word.length()-1));
        }

        return cnt1 + cnt2 + cnt3;
    }


}
