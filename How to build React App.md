## Steps to create a React Application
1. Intall node and NPM
2. Open a folder in Visual Studio Code 
3. Create the sample React app by running below command in a terminal
	`npx create-react-app my-blog --use-npm`
4. Start the application by running the command: `npm start`

## Building React Application

### Building and hosting a React Application in AWS cloud
    https://www.linkedin.com/learning/react-creating-and-hosting-a-full-stack-site/creating-the-app-component?u=2154233

### Creating a Dynamic form application 
      https://codeburst.io/reactjs-a-quick-tutorial-to-build-dynamic-json-based-form-a4768b3151c0
	  

### Adding pages to an React App. 
1. Create a page in the following path `./src/pages/HomePage.js`
2. Add the content some like 
``` javascript

import React from 'react'; 
const HOME_PAGE = () => (
<>
<h1>Welcome to Dynamo Form Application</h1>
<p>
 </p>
</>);

export default HOME_PAGE;

``` 	  
3. Add the page in App.js by the following steps/ 
``` javascript
import HOME_PAGE from './pages/HomePage';
function App() {
  return (
    <div className="App">
       <HOME_PAGE/>
    </div>
  );
}

export default App;

```
4. Add React Router
    1. Install React router component using `npm install --save react-router-dom`
    > Note: if you are unable to install and thrown an error like (WARN tsutils@3.17.1 requires a peer of typescript@>=2.8.0 || >= 3.2.0-dev) then you have to install 
    the particular package in this case run `npm install -g tsutils typescript`
        
   2. Import Route component in App.js
``` javascript
        import {
        BrowserRouter as Router,
        Route,
        } from 'react-router-dom';

        function App() {
            return (
                <Router>
                <div className="App">
                <Route path="/" component={HOME_PAGE} exact/>
                </div>
                </Router>
                
            );
        }
```

### Debugging in the Editor
Visual Studio Code

You would need to have the latest version of VS Code and VS Code Firefox Debugger Extension installed.
https://marketplace.visualstudio.com/items?itemName=firefox-devtools.vscode-firefox-debug

Then add the block below to your launch.json file and put it inside the .vscode folder in your app’s root directory.
```
{
  "version": "0.2.0",
  "configurations": [{
    "name": "Chrome",
    "type": "chrome",
    "request": "launch",
    "url": "http://localhost:3000",
    "webRoot": "${workspaceRoot}/src",
    "sourceMapPathOverrides": {
      "webpack:///src/*": "${webRoot}/*"
    }
  }]
}
```
> Note: the URL may be different if you've made adjustments via the HOST or PORT environment variables.


## References:
1. React Official site https://reactjs.org/
2. React Tutorials https://reactnative.dev/docs/tutorial
3. React stateful https://redux.js.org/
4. React router https://reacttraining.com/react-router/
5. React Test https://jestjs.io/
