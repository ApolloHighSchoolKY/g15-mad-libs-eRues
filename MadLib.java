//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MadLib
{
	private ArrayList<String> verbs = new ArrayList<String>();
	private ArrayList<String> nouns = new ArrayList<String>();
	private ArrayList<String> adjectives = new ArrayList<String>();
	private String story = "";

	public MadLib()
	{
		verbs.add("punched");
		nouns.add("Wal-Mart");
		adjectives.add("massive");
		story = "I punched Walmart in a massive way.";
	}

	public MadLib(String fileName)
	{
		//load stuff
		loadNouns();
		loadVerbs();
		loadAdjectives();

		try
		{
			String ogStory = "";
			Scanner stringMaker = new Scanner(fileName);
			while(stringMaker.hasNext())
			{
				ogStory += stringMaker.next();
			}

			stringMaker.close();
			
			//Read the different parts of the story and concatenate the resulting
			//story using the symbols to tell you the parts of speech
			Scanner reader = new Scanner(ogStory);

			//While there is more of the story, read in the word/symbol
			while(reader.hasNext())
			{
				if(reader.next().equals("@"))
				{
					story += getRandomVerb();
				}
				else if(reader.next().equals("#"))
				{
					story += getRandomNoun();
				}
				else if(reader.next().equals("&"))
				{
					story += getRandomAdjective();
				}
				else
				{
					story += reader.next();
				}
			}
				//If what was read in is one of the symbols, find a random
				//word to replace it.
				reader.close();
		}


		catch(Exception e)
		{
			System.out.println("Houston we have a problem!");
		}

	}

	public void loadNouns()
	{
		try
		{
			Scanner reader = new Scanner(new File("nouns.dat"));

			while(reader.hasNext());
			{
				nouns.add(reader.next());
			}

			reader.close();
		}
		catch(Exception e)
		{
			System.out.println("nouns.dat does not exist");
		}

	}

	public void loadVerbs()
	{
		try
		{
			Scanner reader = new Scanner(new File("verbs.dat"));

			while(reader.hasNext())
			{
				verbs.add(reader.next());
			}

			reader.close();
		}
		catch(Exception e)
		{
			System.out.println("verbs.dat does not exist");
		}
	}

	public void loadAdjectives()
	{
		try
		{
			Scanner reader = new Scanner(new File("adjectives.dat"));

			while(reader.hasNext())
			{
				adjectives.add(reader.next());
			}

			reader.close();
		}
		catch(Exception e)
		{
			System.out.println("adjectives.dat does not exist");
		}
	}

	public String getRandomVerb()
	{
		return "" + verbs.get((int)(Math.random()*verbs.size()));
	}

	public String getRandomNoun()
	{
		return "" + nouns.get((int)(Math.random()*nouns.size()));
	}

	public String getRandomAdjective()
	{
		return "" + adjectives.get((int)(Math.random()*adjectives.size()));
	}

	public String toString()
	{
		return "" + story;
	}
}