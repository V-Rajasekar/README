# Github Actions
## Build, Deploy, and Test CI/CD Pipelines from GitHub
- Learn about CI/CD pipelines and how to create your own workflow with Github Actions
- Integrate scripts and actions into your workflow to build and test your application
- Deploy your application to the cloud using Github Actions

Git is a distributed version control system
Github is a cloud based code hosting platform for collaboration and version control
Github flow is a branching strategy or a workflow. It contains plug and play
task/actions or custom scripts to execute.
These workflow are executed by runner

what is Github Actions ?
- Github Action is a predefined task that perform something such as building container, deploying to Kuberneteus, login to clous provider, accessing your cloud storage(Key vault).
- It easy to automate software workflows with Continuous Integration and Continuous Delivery (CI/CD). Build, test, and deploy your code right from GitHub.
- It contains the plugin play task or custom


what is Runner ? 
Runner is a machine that has installed the Github runner to execute the workflow in your repos. Depending on the PS and tools only certain runner can run certain workflow. 
Private runner or self hosted runners are allowed in Github.

How to write this workflow using which language or format ? 
YAML is a Markup language used to Format & Represent Data, Superset of JSON,Easy to read / designed with
human readability in mind, Convert between JSON and YAML
 
YAML
Data Types: 
 
- **Nulls** 
`variable: null
(null | Null | NULL | ~)
`
- **Numbers**
`variable: 123`

- **Strings**
`variable: "123"`
- **Booleans**
`Variable: True`
`(True/False, Yes/No, On/Off)`

**Lists**

- Elements will be added as long as
indentation is in place
- Lists can be defined in block or square
brackets syntax: 

**variable:**
```yml
- one
- two
- three
```
`variable: [one, two, three]`

 **Maps**
 - Requires indentation and a key
followed by a colon and space
- Can be defined in block or round
bracket syntax: </br>
```yml
cat:
    name: Mirana
    color: brown
    age: 3 years
    eye-color: green
    weight: 3.3kg
```    
`Cat: {name: Mirana, color: brown,...}`

**Nested Map**
- Can nest maps in maps; lists in maps;
maps in lists
```yml
  cat:
    name: Mirana
    characteristics:
        color: brown
        age: 3 years
        weight: 3.3kgs
    activities:
    - attack
    - jump
    - sleep
```
## Sample Workflow
- File stored in “.github/workflows”
- "on:" Keyword to define the trigger that will initiate the workflow
 `Examples: “push”, “pull_request”, “scheduled”, “fork”, “issue”…`
- "jobs:" 
  -  Group jobs to divide workflow into a
  list of activities (build, test, deploy)
  - Defined with “jobs” keyword
  - Jobs run in parallel by default
  - “needs” keyword can be used to arrange jobs sequentially 
- "job" 
  - Group of steps to be executed by a runner within “job” code block
- "Shell"
  - "Override default shell in the runner
  - Pwsh, bash, sh, cmd, python
- "run"
  - Run commands in the operating system shell

# A simple workflow with two Jobs and there individual steps
```yml
name: first workflow

on: 
  workflow_dispatch:
  
jobs:
  firstjob:
    runs-on: self-hosted
    steps:
      - name: firstJob script
        shell: sh
        run: echo Hello World! This is the first job
    
  secondJob:
      runs-on: ubuntu-latest
      steps:
        - name: secondJob script
          shell: bash
          run: |
             echo this is the second
             echo hurray!
```

## Setup a self-hosted runner and run a Workflow
on it

1. Go back to the repository we created in the previous exercise and click on the “settings” tab. Then within the “Code and automation”
section from the left menu, click on “Actions” > “runners” and then click on the green “New self-hosted runner” button at the top right.:
2. Select your Operating System in “Runner image” and your architecture (x64/arm)
3. Follow the steps listed below architecture to download and install the runner (Hint: you can copy the commands by clicking on them)
4. Once you have completed the previous step, your runner should appear as online/idle in the Github Runner section.
5. Now lets go ahead and remove the self-hosted runner. Click on “settings”, “actions” > “runners” and click on your runner

## Github Actions workflows:actions
you can use the premade tasks/scripts available from Github action market place or  https://github.com/actions

**"uses":**

- Reusable unit of code (premade
tasks/scripts)
- Pass input parameters with the “with”
keyword
- Syntax:
  - "actions/<action_name>@<version/co
mmit/branch>"

(e.g)
```yml
jobs:
 job_with_GH_actions:
 runs-on: ubuntu-latest
 steps:
   - uses: actions/checkout@v2

   - uses: actions/setup-node@v3
    with:
      node-version: 16
   - uses: wxdlong/helloaction@3dc69a523f937b57d06445e71f237b1956
5fb830
     with:
       who-to-greet: ‘live-lesson attendees’
```

## Github Actions Workflows: variables

**Variables (environment variables)**
- Known as environment variables
- Can be defined at workflow level; job
level or step level
- Syntax $(<variable_name>) 

**Secrets:**
- Never commit secrets or sensitive
information into your repository, use
secrets instead
- ${{ secrets.<SECRET_NAME> }}
- Naming secrets with Alpha numerics or underscore GITHUB_
- Some predefined Secrets
Examples:
* GITHUB_ACTION: name of action currently
* running
* GITHUB_EVENT_NAME: event that triggered
* the workflow
* GITHUB_JOB: job id of current job
* GITHUB_REF: branch/tag that triggered workflow

```yml
name: varSecretsWorkflow
env: 
  WORKFLOW_VAR: "I'm a workflow variable"
on: 
  workflow_dispatch:

jobs:
 varjob:
  runs-on: ubuntu-latest
  env: 
    JOB_VAR: "I'm a JOB_VAR variable"
  steps:
    - name: environment variables
      shell: bash
      env: 
        STEP_VAR: "I'm a STEP_VAR variable."
      run: |
        echo $WORKFLOW_VAR
        echo $JOB_VAR
        echo $STEP_VAR
        echo "The following is a secret: ${{ secrets.SOME_SECRET }}, of course, I cant tell you because then it wouldnt be a secret..."
        echo "The following are default environment variables:"
        echo $GITHUB_ACTOR
        echo $GITHUB_JOB
        echo $GITHUB_REF    
```    

# Building and Testing

Below is a Github action workflow to build, test and deploy app to www.surge.sh

```yml
name: build
on:
  push:
    branches: main
  
jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v3
      - name: Cache
        uses: actions/cache@v3.0.8
        with:
          path: ~/.npm
          key: buildCache
      - run: npm ci # instruct it to install the packages it depends on based on the package-lock file in the repository. The difference here is that npm
                    # ci is used in automated environments such as CI pipelines.
    # - run: npm test -- --coverage
    #     env:
    #        CI: true
  #   - name: Upload code coverage
  #     uses: actions/upload-artifact@v3.1.0
  #    with:
  #     name: codecoverage
  #     path: coverage
      - name: build
        run: npm run build
      - name: Upload build files
        uses: actions/upload-artifact@v3.1.0
        with:
          name: build
          path: build
  deploy:
    runs-on: ubuntu-latest
    needs: build
    environment:
         name: production
         url: http://rajasekar-v.surge.sh
    steps:
        - name: Download the Build Artifact
          uses: actions/download-artifact@v3.0.0
          with:
            name: build
        - name: deploy to surge
          run: npx surge --project '.' --domain rajasekar-v.surge.sh
          env:
            SURGE_LOGIN: ${{ secrets.SURGE_LOGIN }}
            SURGE_TOKEN: ${{ secrets.SURGE_TOKEN }}  
```

