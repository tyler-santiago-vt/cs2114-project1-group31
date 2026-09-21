package trivia;
/**
 ** -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 * 
 *  @author Aishwarya Shah
 *  @version Sep 21, 2026
 */
public class QuestionBank
{
    //~ Fields ................................................................
    public Question[] peopleQuestions;
    public Question[] musicQuestions;
    public Question[] historyQuestions;
    public Question[] geographyQuestions;
    public Question[] animalQuestions;


    //~ Constructors ..........................................................
    public QuestionBank()
    {
     // 1. people questions
        peopleQuestions = new Question[] {
            new Question("Who was the first person to walk on the Moon?",
                new String[] {"A) Buzz Aldrin", "B) Neil Armstrong", "C) "
                    + "Yuri Gagarin", "D) John Glenn"}, "B"),
            new Question("Who painted the Mona Lisa?",
                new String[] {"A) Michelangelo", "B) Vincent van Gogh", "C) "
                    + "Leonardo da Vinci", "D) Pablo Picasso"}, "C"),
            new Question("Who is known as the 'Father of Computers'?",
                new String[] {"A) Alan Turing", "B) Charles Babbage", "C) "
                    + "Bill Gates", "D) Steve Jobs"}, "B"),
            new Question("Who wrote Romeo and Juliet?",
                new String[] {"A) William Shakespeare", "B) Charles Dickens",
                    "C) Jane Austen", "D) Oscar Wilde"}, "A"),
            new Question("Who was the first woman to win a Nobel Prize?",
                new String[] {"A) Marie Curie", "B) Rosalind Franklin", "C) "
                    + "Ada Lovelace", "D) Florence Nightingale"}, "A"),
            new Question("Who developed the theory of relativity?",
                new String[] {"A) Isaac Newton", "B) Stephen Hawking", "C)"
                    + " Albert Einstein", "D) Galileo Galilei"}, "C"),
            new Question("Who was the first president of the United States?",
                new String[] {"A) Thomas Jefferson", "B) George Washington",
                    "C) Abraham Lincoln", "D) John Adams"}, "B"),
            new Question("Who wrote the Harry Potter book series?",
                new String[] {"A) J.R.R. Tolkien", "B) Suzanne Collins", "C) "
                    + "J.K. Rowling", "D) C.S. Lewis"}, "C"),
            new Question("Who was famously known as the "
                + "'King of Rock and Roll'?",
                new String[] {"A) Elvis Presley", "B) Johnny Cash", "C) "
                    + "Frank Sinatra", "D) Chuck Berry"}, "A"),
            new Question("Who gave the famous 'I Have a Dream' speech?",
                new String[] {"A) Malcolm X", "B) Nelson Mandela", "C) Martin "
                    + "Luther King Jr.", "D) Muhammad Ali"}, "C")
        };
        // 2. history questions
        historyQuestions = new Question[] {
            new Question("In what year did World War II end?",
                new String[] {"A) 1943", "B) 1944", "C) 1945", "D) 1946"}, "C"),
            new Question("Which ancient civilization built the "
                + "pyramids at Giza?",
                new String[] {"A) Romans", "B) Egyptians", "C) Greeks",
                    "D) Persians"}, "B"),
            new Question("Who was the first emperor of Rome?",
                new String[] {"A) Julius Caesar", "B) Nero", "C) Augustus",
                    "D) Constantine"}, "C"),
            new Question("What famous wall fell in 1989?",
                new String[] {"A) Great Wall of China", "B) Hadrian's Wall",
                    "C) Berlin Wall", "D) Western Wall"}, "C"),
            new Question("Which ship sank on its maiden voyage in 1912?",
                new String[] {"A) Britannic", "B) Lusitania", "C) Titanic",
                    "D) Mayflower"}, "C"),
            new Question("Who founded the Mongol Empire?",
                new String[] {"A) Kublai Khan", "B) Genghis Khan",
                    "C) Attila the Hun", "D) Timur"}, "B"),
            new Question("Which revolution began in France in 1789?",
                new String[] {"A) Industrial Revolution", "B) "
                    + "French Revolution", "C) Russian Revolution", "D) "
                        + "Glorious Revolution"}, "B"),
            new Question("Who was the British monarch during much of the "
                + "American Revolutionary War?",
                new String[] {"A) George I", "B) George II", "C) George III",
                    "D) George IV"}, "C"),
            new Question("What ancient city was buried by Mount Vesuvius in"
                + " AD 79?",
                new String[] {"A) Athens", "B) Pompeii", "C) Sparta", "D) "
                    + "Carthage"}, "B"),
            new Question("What famous trade network connected China with "
                + "Europe and the Middle East?",
                new String[] {"A) Amber Road", "B) Royal Road", "C) "
                    + "Silk Road", "D) Spice Route"}, "C")
        };
        // 3. music questions
        musicQuestions = new Question[] {
            new Question("Who was known as the 'King of Pop'?",
                new String[] {"A) Prince", "B) Michael Jackson", "C) "
                    + "Elvis Presley", "D) Stevie Wonder"}, "B"),
            new Question("Which band released Abbey Road?",
                new String[] {"A) The Rolling Stones", "B) Queen", "C) "
                    + "The Beatles", "D) Pink Floyd"}, "C"),
            new Question("Which instrument typically has 88 keys?",
                new String[] {"A) Organ", "B) Piano", "C) Harpsichord",
                    "D) Accordion"}, "B"),
            new Question("Who sang 'Rolling in the Deep'?",
                new String[] {"A) Beyoncé", "B) Rihanna", "C) Adele", "D)"
                    + " Taylor Swift"}, "C"),
            new Question("Which composer wrote the famous Fifth Symphony?",
                new String[] {"A) Mozart", "B) Beethoven", "C) Bach", "D) "
                    + "Chopin"}, "B"),
            new Question("Which genre of music originated in New Orleans?",
                new String[] {"A) Jazz", "B) Reggae", "C) Country", "D)"
                    + " Disco"}, "A"),
            new Question("Which singer released the album 21?",
                new String[] {"A) Adele", "B) Lady Gaga", "C) Amy Winehouse",
                    "D) Dua Lipa"}, "A"),
            new Question("How many strings does a standard violin have?",
                new String[] {"A) 3", "B) 4", "C) 5", "D) 6"}, "B"),
            new Question("Which group is one of the world's most famous "
                + "K-pop acts?",
                new String[] {"A) EXO", "B) BLACKPINK", "C) BTS", "D) TWICE"},
                "C"),
            new Question("What is the highest common female singing voice?",
                new String[] {"A) Alto", "B) Mezzo-soprano", "C) Tenor", "D) "
                    + "Soprano"}, "D")
        };
        // 4. geography questions
        geographyQuestions = new Question[] {
            new Question("What is the largest country in the world by land"
                + " area?",
                new String[] {"A) Canada", "B) China", "C) United States", "D)"
                    + " Russia"}, "D"),
            new Question("What is the capital of Australia?",
                new String[] {"A) Sydney", "B) Melbourne", "C) Canberra", "D)"
                    + " Brisbane"}, "C"),
            new Question("Which river is traditionally considered the longest "
                + "in the world?",
                new String[] {"A) Amazon", "B) Nile", "C) Mississippi", "D)"
                    + " Yangtze"}, "B"),
            new Question("What is the smallest country in the world?",
                new String[] {"A) Monaco", "B) Liechtenstein", "C) Vatican"
                    + " City", "D) San Marino"}, "C"),
            new Question("On which continent is the Sahara Desert?",
                new String[] {"A) Asia", "B) Africa", "C) South America",
                    "D) Australia"}, "B"),
            new Question("Mount Everest is located in which mountain range?",
                new String[] {"A) Andes", "B) Alps", "C) Himalayas", "D)"
                    + " Rockies"}, "C"),
            new Question("Which ocean is between Africa and Australia?",
                new String[] {"A) Atlantic Ocean", "B) Pacific Ocean", "C)"
                    + " Arctic Ocean", "D) Indian Ocean"}, "D"),
            new Question("What is the capital of Japan?",
                new String[] {"A) Kyoto", "B) Osaka", "C) Tokyo",
                    "D) Hiroshima"}, "C"),
            new Question("Which U.S. state is the largest by area?",
                new String[] {"A) Texas", "B) California", "C) Alaska",
                    "D) Montana"}, "C"),
            new Question("What is the longest mountain range on land?",
                new String[] {"A) Himalayas", "B) Andes", "C) Rockies", "D) "
                    + "Alps"}, "B")
        };
        // 5. animal questions
        animalQuestions = new Question[] {
            new Question("What is the largest animal on Earth?",
                new String[] {"A) African elephant", "B) Blue whale", "C)"
                    + " Giraffe", "D) Orca"}, "B"),
            new Question("What is the fastest land animal?",
                new String[] {"A) Lion", "B) Greyhound", "C) Cheetah", "D) "
                    + "Leopard"}, "C"),
            new Question("How many legs does a spider have?",
                new String[] {"A) 6", "B) 8", "C) 10", "D) 12"}, "B"),
            new Question("What is a baby kangaroo called?",
                new String[] {"A) Cub", "B) Calf", "C) Joey", "D) Kit"}, "C"),
            new Question("Which animal is famous for changing its color?",
                new String[] {"A) Chameleon", "B) Gecko", "C) Iguana", "D) "
                    + "Komodo dragon"}, "A"),
            new Question("What is the only mammal capable of true sustained "
                + "flight?",
                new String[] {"A) Flying squirrel", "B) Bat", "C) Sugar glider",
                    "D) Flying lemur"}, "B"),
            new Question("What is the largest living bird?",
                new String[] {"A) Bald eagle", "B) Emu", "C) Ostrich", "D) "
                    + "Albatross"}, "C"),
            new Question("What type of animal is a Komodo dragon?",
                new String[] {"A) Amphibian", "B) Mammal", "C) Bird", "D)"
                    + " Reptile"}, "D"),
            new Question("Which animal is famous for its black-and-white"
                + " stripes?",
                new String[] {"A) Zebra", "B) Okapi", "C) Skunk", "D) Panda"},
                "A"),
            new Question("What is the largest species of big cat?",
                new String[] {"A) Lion", "B) Jaguar", "C) Tiger", "D) Leopard"},
                "C")
        };
        }


    //~Public  Methods ........................................................
        /**
         * Returns the question object specified by category and
         * questionIndex/questionNumber.
         *
         * @param category The string name or code of the category
         * @param questionNumber The index of the question in the array (0 to 9)
         * @return the requested Question object or null if category is invalid
         */
        public Question getQuestion(String category, int questionNumber)
        {
            if (category.equalsIgnoreCase("People") ||
                category.equalsIgnoreCase("A"))
            {
                return peopleQuestions[questionNumber];
            }
            else if (category.equalsIgnoreCase("Music") ||
                category.equalsIgnoreCase("B"))
            {
                return musicQuestions[questionNumber];
            }
            else if (category.equalsIgnoreCase("History") ||
                category.equalsIgnoreCase("C"))
            {
                return historyQuestions[questionNumber];
            }
            else if (category.equalsIgnoreCase("Geography") ||
                category.equalsIgnoreCase("D"))
            {
                return geographyQuestions[questionNumber];
            }
            else if (category.equalsIgnoreCase("Animals") ||
                category.equalsIgnoreCase("E"))
            {
                return animalQuestions[questionNumber];
            }
           
            return null;
        }
     }
