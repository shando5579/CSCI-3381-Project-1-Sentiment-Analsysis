package TweetPredictionPackage;

public class MainTester {

	public static void main(String[] args) 
	{
		Tweet firstTweet = new Tweet("0,0000000001,Shando,Ooga");
		Tweet secondTweet = new Tweet("0,9990536256,Max,Hi Shandon :^)");
		Tweet thirdTweet = new Tweet("0,8552636256,Max,There's a troll chasing me");
		
		
		TweetCollection TestTweets = new TweetCollection("testCollection","./TweetPredictionPackage/testFileIn.txt");
		
		//adds sample tweets to the testcollection
		TestTweets.addTweet(firstTweet);
		TestTweets.addTweet(secondTweet);
		TestTweets.addTweet(thirdTweet);
		
		System.out.println("Gets Tweets from TweetID 0000000001: " + TestTweets.getTweetById("0000000001"));
		System.out.println("\nGets Tweets from Twitter user 'Max': " + TestTweets.getTweetByUserName("Max"));
		
		//prints all tweets
		System.out.println("\n" + TestTweets);
		System.out.println("\nAll Tweet IDs that exist in the collection: " + TestTweets.getAllCollectionIds());
		System.out.println("\nTweet IDs that are made by Max: " + TestTweets.getCollectionIds("Max"));
	}

}
