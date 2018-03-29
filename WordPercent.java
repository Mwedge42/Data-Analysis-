package dataScience;

import java.io.*;

public class WordPercent {
	String fileToAnalyze;
	
	WordPercent()
	{
		System.out.println("");
		fileToAnalyze="";
		
	}
	
	public String [] getAuthorName(String fileToRead, int postNumber)
	{
		String [] authorNames=new String[6466];
		
		try
		{
			FileReader myFileReader=new FileReader(fileToRead);
			BufferedReader myBufferReader= new BufferedReader(myFileReader);
			String line=null;
			int lineCounter=0;
			while ((line=myBufferReader.readLine())!=null)
			{
				lineCounter+=1;
				if(lineCounter == postNumber)
				{
				 System.out.print(line);
				}
			}
			return authorNames;
		}
		catch (Exception ex)
		{
			System.out.println("I don't think I was able to find your file");
		}
		
		return authorNames;
			
	}
	
	public int [] getUpvotes(String fileToRead, int postNumber)
	{
		int [] numUpvotes=new int[6466];
		
		try
		{
			FileReader myFileReader=new FileReader(fileToRead);
			BufferedReader myBufferReader= new BufferedReader(myFileReader);
			String line=null;
			int commentCounter=0;
			while ((line=myBufferReader.readLine())!=null)
			{
				commentCounter+=1;
				if(commentCounter == postNumber)
				{
				 System.out.print(line);
				}
			}
			return numUpvotes;
			
		}
		catch (Exception ex)
		{
			System.out.println("I don't think I was able to find your file");
		}
		
		return numUpvotes;
			
	}
	
	public int [] getNumComments(String fileToRead, int commentsOfString)
	{
		int [] numComments=new int[6466];
		
		try
		{
			FileReader myFileReader=new FileReader(fileToRead);
			BufferedReader myBufferReader= new BufferedReader(myFileReader);
			String line=null;
			int commentCounter=0;
			while ((line=myBufferReader.readLine())!=null)
			{
				commentCounter+=1;
				if(commentCounter == commentsOfString)
				{
				 System.out.print(line);
				}
			}
			return numComments;
			
		}
		catch (Exception ex)
		{
			System.out.println("I don't think I was able to find your file");
		}
		
		return numComments;
			
	}
	
	
	
	RedditPost [] getStringPosts(String fileToRead, String stringToFind)
	{
		RedditPost [] newPosts=new RedditPost[6466];
		System.out.println("The following posts containing \"" +stringToFind+ "\" were: \n");
		
		try
		{
			FileReader myFileReader=new FileReader(fileToRead);
			BufferedReader myBufferReader= new BufferedReader(myFileReader);
			String line=null;
			int postCounter=1;
			float postWithString = 0;
			float postPercent = 0;
			boolean stringExistence = false;
			
			
			while ((line=myBufferReader.readLine())!=null)
			{
				if(line.contains(stringToFind))
				{
				 System.out.println(postCounter +": " +line);
				 newPosts[postCounter]=new RedditPost(line);
				 postCounter+=1;
				 stringExistence = true;
				}
				else
				{
				 newPosts[postCounter]=new RedditPost(line);
				 postCounter+=1;
				}
				
			}
			if(stringExistence == true)
			{
			 System.out.println("\nEnd of text file.");	
			}
			else
			{
			 System.out.println("None, that word does not exist in this text file.");
			 System.exit(0);
			}
			
			return newPosts;
			
		}
		catch (Exception ex)
		{
			System.out.println("I don't think I was able to find your file");
		}
		return newPosts;
			
	}
	
	/*RedditPost [] getPercent(String fileToRead, String stringToFind)
	{
		RedditPost [] newPercentPosts=new RedditPost[6466];
		
		try
		{
			FileReader myFileReader=new FileReader(fileToRead);
			BufferedReader myBufferReader= new BufferedReader(myFileReader);
			String line=null;
			int postCounter=1;
			float postWithString = 0;
			float postPercent = 0;
			
			while ((line=myBufferReader.readLine())!=null)
			{
				if(line.contains(stringToFind))
				{
				 newPercentPosts[postCounter]=new RedditPost(line);
				 postCounter+=1;
				 postWithString+=1;
				}
				else
				{
				 newPercentPosts[postCounter]=new RedditPost(line);
				 postCounter+=1;
				}
			}
			postPercent = (postWithString / postCounter)*100;
			System.out.println("\nThis file contained \"" +stringToFind+ "\" " +postWithString+ " times.");
			System.out.println("Posts containing this word make up " +postPercent+ "% of the text file.");
		
			return newPercentPosts;
			
		}
		catch (Exception ex)
		{
			System.out.println("File not Found");
		}
		return newPercentPosts;
			
	}*/
	RedditPost [] getPercentPost(String fileToRead, String stringToFind)
	{
		
		RedditPost [] newPosts=new RedditPost[6466];
		try
		{
			FileReader myFileReader=new FileReader(fileToRead);
			BufferedReader myBufferReader= new BufferedReader(myFileReader);
			String line=null;
			int lineNumber = 0;
			float postWithString = 0;
			float postPercent = 0;
			while ((line=myBufferReader.readLine())!=null)
			{
				if (line.contains(stringToFind))
				{
				 lineNumber += 1;
				 postWithString+=1;
				}
				else
				{
				 newPosts[lineNumber]=new RedditPost(line);
				 lineNumber+=1;
				}
			}
			postPercent = (postWithString / lineNumber)*100;
			System.out.println("\nThis file contained your selected word " +postWithString+ " times.");
			System.out.println("Posts containing this word make up " +postPercent+ "% of the text file.");
			return newPosts;
		}
		catch (Exception ex)
		{
			System.out.println("Post does not actually exist");
			return newPosts;
		}
		
	}
	
	RedditPost [] getSelectPost(String fileToRead, int commentsOfString)
	{
		
		RedditPost [] newPosts=new RedditPost[6466];
		try
		{
			FileReader myFileReader=new FileReader(fileToRead);
			BufferedReader myBufferReader= new BufferedReader(myFileReader);
			String line=null;
			int lineNumber = 0;
			while ((line=myBufferReader.readLine())!=null)
			{
				if (lineNumber == commentsOfString -1)
				{
				 System.out.println("\n\t" +line);
				 lineNumber += 1;;
				}
				else
				{
				 newPosts[lineNumber]=new RedditPost(line);
				 lineNumber+=1;
				}
			}
		}
		catch (Exception ex)
		{
			System.out.println("Post does not actually exist");
			return newPosts;
		}
		return newPosts;
		
	}
}