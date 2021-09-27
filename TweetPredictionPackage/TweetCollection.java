package TweetPredictionPackage;

import java.util.Iterator;
import java.util.TreeSet;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/* Code Citation #1
 * 
 * Code Used: readFile() method, writeFile() methods, and doWrite() method
 * Author: Mark Doderer
 * Source: classroster/Roster.java
 * Purpose: file read and write
 */

public class TweetCollection 
{
	private TreeSet<Tweet> tweets;
	private String collectionName;
	private String fileName;

	//default constructor
	public TweetCollection()
	{
		collectionName = null;
		fileName = null;
		tweets = new TreeSet<Tweet>();
	}
	
	//constructor with a name and filename
	public TweetCollection(String cName, String fName)
	{
		this();
		collectionName = cName;
		fileName = fName;
		readFile();
	}
	
	//********************** START OF COLLECTION MANAGEMENT **********************
	//adds the tweet object to the collection
	public void addTweet(Tweet tweet)
	{
		tweets.add(tweet);
	}
	
	//removes the tweet object from the collection
	public void removeTweet(Tweet tweet)
	{
		tweets.remove(tweet);
	}
	
	//removes the tweet object(s) from the collection that contains the specified id
	public void removeTweetById(String tweetId)
	{
		tweets.remove(this.getTweetById(tweetId));
	}
	
	//gets a tweet object(s) that contains the specified id
	public Tweet getTweetById (String tweetId)
	{	
		Iterator<Tweet> iter = tweets.iterator();
		
		while(iter.hasNext())
		{
			Tweet tweet = iter.next();
			if (tweet.getTweetId().equals(tweetId))
				return tweet;
		}
			return null;
	}
	
	//gets a tweet object(s) that contains the specified username
	public Tweet getTweetByUserName (String tweetUserName)		//gets a tweet in the tweets treeset by its username
	{		 
		Iterator<Tweet> iter = tweets.iterator();
		
		while(iter.hasNext())
		{
			Tweet tweet = iter.next();
			if (tweet.getTweetUserName().equals(tweetUserName))
				return tweet;
		}
			return null;
	}
	//*********************** END OF COLLECTION MANAGEMENT ***********************
	
	//*********************** START OF COLLECTION FUNCTIONS **********************
	//toString for object, displays all information from Tweet object
	public String toString()
	{
		String toReturn = "";
		Iterator<Tweet> iter = tweets.iterator();
		
		while(iter.hasNext())
		{
			Tweet tweet = iter.next();
			toReturn += tweet;
		}
		return toReturn;
	}
	
	//gets all ids in the collection
	public String getAllCollectionIds()
	{
		String toReturn = "";
		Iterator<Tweet> iter = tweets.iterator();
		
		while (iter.hasNext())
		{
			Tweet tweet = iter.next();
			toReturn += "\nTweet ID: " + tweet.getTweetId();
		}
		return toReturn;
	}
	
	//gets all ids from a specified user in the collection
	public String getCollectionIds(String userName)
	{
		String toReturn = "";
		Iterator<Tweet> iter = tweets.iterator();
		
		while (iter.hasNext())
		{
			Tweet tweet = iter.next();
			if (tweet.getTweetUserName().equals(userName))
				toReturn += "\nTweet ID: " + tweet.getTweetId();
		}
		return toReturn;
	}
	//*********************** END OF COLLECTION FUNCTIONS ************************
	
	//****************** START OF FILE MANAGEMENT & FUNCTIONS ********************
	//reads a file
	private void readFile()
	{
		BufferedReader lineReader = null;
		try 
		{
			FileReader fr = new FileReader(fileName);
			lineReader = new BufferedReader(fr);
			String tweet;
			while ((tweet = lineReader.readLine())!=null) 
			{
				addTweet(new Tweet(tweet));
			}
		} catch (Exception e)
		{
			System.err.println("there was a problem with the file reader, try different read type.");
			try
			{
				
				lineReader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(fileName.substring(1))));
				String tweet;
				while ((tweet = lineReader.readLine())!=null) 
				{
					addTweet(new Tweet(tweet));
				}
			} catch (Exception e2)
			{
				System.err.println("there was a problem with the file reader, try again.  either no such file or format error");
			} 
			finally
			{
				if (lineReader != null)
				{
					try
					{
						lineReader.close();
					} catch (IOException e2)
					{
						System.err.println("could not close BufferedReader");
					}
				}
						
			}			
		} finally
		{
			if (lineReader != null)
			{
				try
			{
					lineReader.close();
				} catch (IOException e) {
					System.err.println("could not close BufferedReader");
				}
			}
		}
			
	}
}


