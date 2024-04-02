What are LLMs ?

- LLM stands for large language models.
- These are statistical models that infer the next word based on likelihoods
or probabilities
- It takes what has already been split out and continuously infers the next
in the sequence
- Kind of like fast guessing machines

Language Models =/= Knowledge model

- Language models exist only to create human like speech. They do not guarantee accuracy of statements
- There are other models trained to provide accurate results
- Be wary of what you read from an LLM. The results they spit out are just byproducts of statistics  

Generative AI is a just a prediction machine

- Inference, or predicting the next word based on the previous word is at the
heart of generative AI.

“To be, or not to be, , that is the question: Whether 'tis nobler in the mind to suffer”

- Shakepeare
- We encode it using n grams
  - N grams is just a grouping of words with “n” elements. N in this case can be anything, lets say 3 and are commonly referred to as tokens.
  Step 1: N Gram conversion (to, be, or), (be, or, not), (or, not, to), (not, to, be), (to, be, that), …
  Step 2: Creating an inference matrix stating what the next words can be for each n-gram
  <p>
    (to, be, or) -> not
    (be, or, not) -> to
    (or, not, to) -> be
    (not, to, be) -> that
    (to, be, that) -> is
    So on and so forth…  </p>

**What happens next depends on what happened in the past**
We take a look at the existing input and then infer what the next word will be
depending on the existing input. This is why we must give a prompt, this acts as a
seed and will start the inference cycle.
Lets say we give a prompt and we’re looking at 3 tokens:
To be or not
The input to the LLM is now (be, or, not)
Now we feed the last 3-gram into the LLM again and get the next predicted word
(or, not, to) which infers be This leads to a newly generated prompt of: To be or not to be

Hallucinations happen to everyone
Robert has a white dog, Kathy has a white cat.
The previous 3-gram conversion becomes
(Robert, has, a) -> white
(has, a, white) -> cat, dog
(a, white, dog) -> Kathy
(white, dog, Kathy) -> has
(Kathy, has, a) -> white
(a, white, cat) -> [end of sentence]

when you prompt:  Robert has a white
Feeding the last 3 gram back in (has, a, white) we now have 2 options to pick from, cat or dog.
LLMs generally pick the next word based on the existing input. When phrasing is common, then tend to hallucinate since there are more
options for next words.

### What is Prompt Engineering ?

● Prompt engineering is a relatively new discipline for developing and
optimizing prompts to efficiently use language models (LMs) for a wide
variety of applications and research topics.
● Prompt engineering skills help to better understand the capabilities and
limitations of large language models (LLMs).
● Researchers use prompt engineering to improve the capacity of LLMs on a
wide range of common and complex tasks such as question answering and
arithmetic reasoning.
● Developers use prompt engineering to design robust and effective prompting
techniques that interface with LLMs and other tools.

### Basics of Prompt Engineering

- Text summarization
  
  - The "A:" is an explicit prompt format that's used in question answering.
  
   ```yml
   Prompt: Explain <>
   A:
   
   case2://
   Prompt:
     <content>
     Explain the above in one sentence
   ```

- Information Extraction
  - Mention <> mentioned in the paragraph.
- Question Answering
  - One of the best ways to get the model to respond to specific answers is to improve the format of the prompt.
● A prompt could combine instructions, context, input, and output indicators to get improved results.
- Code Generation
  Prompt: Generate code to request user name and greet the user in console.
  
  When we query an LLM without any examples, we are utilizing it’s prebuilt knowledge of the
world to answer the prompt.
Alternatively when we provide examples, then we are guiding the LLM to learn from new
information

#### Prompting types

- Zero Shot Prompting: Providing a prompt without any context.
- Few Shot Prompting: we provide some examples and the LLM can learn from the context of the prompt in order to give a better answer
  <p>
  prompt:
  Example:
  To do a "farduddle" means to jump up and down really fast. An example of a sentence that uses the word farduddle is:
    Output:
    When we won the game, we all started to farduddle in celebration.
  </p>

#### zero-shot chain of thought (COT)

Can trigger chain of thought prompting with Few shot and Zero
Shot. Few Shot prompting can be triggered via examples
Zero Shot can be triggered with a
prompt “Let’s think step by step”

- To start a zero-shot chain of thought response, what prompt should I use with the LLM "Think about it step by step".
-
