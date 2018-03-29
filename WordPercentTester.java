package dataScience;

import java.io.*;
import java.util.Scanner;

public class WordPercentTester 
{
	public static void main(String[] args) 
	{
		Scanner userInput = new Scanner(System.in);
		String stringToFind = null;
		int postNumber;
		
		System.out.println("Hello I am a data management bot\nPlease enter a word you want to find: ");
		stringToFind = userInput.next();
		
		WordPercent myReader=new WordPercent();
		RedditPost [] posts=myReader.getStringPosts("redditPost.txt",stringToFind);
		
		System.out.println("\nEnter the number line of a post to view more information: ");
		postNumber = userInput.nextInt();
		
		System.out.println("You entered " +postNumber+ " which corresponds to the post:");
		RedditPost [] selectPost = myReader.getSelectPost("redditPost.txt", postNumber);
		
		System.out.print("\nAthor:  ");
		String [] authorNames = myReader.getAuthorName("Authors.txt",postNumber);
		
		System.out.print("\nComments:  ");
		int [] numComments = myReader.getNumComments("Comments.txt",postNumber);
		
		System.out.print("\nUpvotes:  ");
		int [] numUpvotes = myReader.getUpvotes("Upvotes.txt",postNumber);
	    
		System.out.println();
		RedditPost [] postpercent =myReader.getPercentPost("redditPost.txt", stringToFind);
		
	}
}
