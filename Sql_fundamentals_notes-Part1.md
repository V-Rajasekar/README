





<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
  <link rel="dns-prefetch" href="https://assets-cdn.github.com">
  <link rel="dns-prefetch" href="https://avatars0.githubusercontent.com">
  <link rel="dns-prefetch" href="https://avatars1.githubusercontent.com">
  <link rel="dns-prefetch" href="https://avatars2.githubusercontent.com">
  <link rel="dns-prefetch" href="https://avatars3.githubusercontent.com">
  <link rel="dns-prefetch" href="https://github-cloud.s3.amazonaws.com">
  <link rel="dns-prefetch" href="https://user-images.githubusercontent.com/">



  <link crossorigin="anonymous" media="all" integrity="sha512-vEiCH42J0Z75K8k43QJVo3TeWXpPSjhuyaJLAGYvTHNBexT4HQb1wFP7XY2EKbK37eFbQEk2Z2znKPIUbdMJoA==" rel="stylesheet" href="https://assets-cdn.github.com/assets/frameworks-a92bcfa8d646a4f8874998ac7b7ec3b8.css" />
  <link crossorigin="anonymous" media="all" integrity="sha512-T+lRvDPvk6xOdj1Idh+aDG1ilsansfLCVfoGHw9MJZg6aW4HTIxEeIHAZU91YWlT+WQkwC0eETD+e+wejk2v7A==" rel="stylesheet" href="https://assets-cdn.github.com/assets/github-91df826379f0871368c7aeb5706cae37.css" />
  
  
  
  
  

  <meta name="viewport" content="width=device-width">
  
  <title>oreilly_sql_fundamentals_for_data/sql_fundamentals_notes.md at master · thomasnield/oreilly_sql_fundamentals_for_data</title>
    <meta name="description" content="Resources for O&#39;Reilly &quot;SQL Fundamentals for Data&quot; online training - thomasnield/oreilly_sql_fundamentals_for_data">
    <link rel="search" type="application/opensearchdescription+xml" href="/opensearch.xml" title="GitHub">
  <link rel="fluid-icon" href="https://github.com/fluidicon.png" title="GitHub">
  <meta property="fb:app_id" content="1401488693436528">

    
    <meta property="og:image" content="https://avatars1.githubusercontent.com/u/7420801?s=400&amp;v=4" /><meta property="og:site_name" content="GitHub" /><meta property="og:type" content="object" /><meta property="og:title" content="thomasnield/oreilly_sql_fundamentals_for_data" /><meta property="og:url" content="https://github.com/thomasnield/oreilly_sql_fundamentals_for_data" /><meta property="og:description" content="Resources for O&#39;Reilly &quot;SQL Fundamentals for Data&quot; online training - thomasnield/oreilly_sql_fundamentals_for_data" />

  <link rel="assets" href="https://assets-cdn.github.com/">
  <link rel="web-socket" href="wss://live.github.com/_sockets/VjI6MzMzODg3ODg3OjdlMzZkY2UwZjUwOWVjMjdiMTI3ZjVkMDZmMjdkZTZhNDM0ZmU0ODUwODU0YTA3NDM5MjBhODhjM2VlYzAwYmU=--5991cf78c108d3f9e9f77c75b9d55a1315899161">
  <meta name="pjax-timeout" content="1000">
  <link rel="sudo-modal" href="/sessions/sudo_modal">
  <meta name="request-id" content="FB38:6A0F:32EE1AF:48ACB84:5BF31607" data-pjax-transient>


  

  <meta name="selected-link" value="repo_source" data-pjax-transient>

      <meta name="google-site-verification" content="KT5gs8h0wvaagLKAVWq8bbeNwnZZK1r1XQysX3xurLU">
    <meta name="google-site-verification" content="ZzhVyEFwb7w3e0-uOTltm8Jsck2F5StVihD0exw2fsA">
    <meta name="google-site-verification" content="GXs5KoUUkNCoaAZn7wPN-t01Pywp9M3sEjnt_3_ZWPc">

  <meta name="octolytics-host" content="collector.githubapp.com" /><meta name="octolytics-app-id" content="github" /><meta name="octolytics-event-url" content="https://collector.githubapp.com/github-external/browser_event" /><meta name="octolytics-dimension-request_id" content="FB38:6A0F:32EE1AF:48ACB84:5BF31607" /><meta name="octolytics-dimension-region_edge" content="ams" /><meta name="octolytics-dimension-region_render" content="iad" /><meta name="octolytics-actor-id" content="21145085" /><meta name="octolytics-actor-login" content="V-Rajasekar" /><meta name="octolytics-actor-hash" content="d660b54c87543276c3ac68395922e5c457866fffc3dcca1700ada98aca1d5364" />
<meta name="analytics-location" content="/&lt;user-name&gt;/&lt;repo-name&gt;/blob/show" data-pjax-transient="true" />



    <meta name="google-analytics" content="UA-3769691-2">

  <meta class="js-ga-set" name="userId" content="7641d7a30a4c87c4f6ba290f6c5cff62" %>

<meta class="js-ga-set" name="dimension1" content="Logged In">



  

      <meta name="hostname" content="github.com">
    <meta name="user-login" content="V-Rajasekar">

      <meta name="expected-hostname" content="github.com">
    <meta name="js-proxy-site-detection-payload" content="YTdjMWYzNzI0MjFjYzdkODMzM2EzNDdmMzRkYTg3MTk3NDE1ZTEyOWQ3MTNmMzAyMGQ5YWNkYTdkOTQyYmY5MHx7InJlbW90ZV9hZGRyZXNzIjoiNTEuMTc1LjExOC44NyIsInJlcXVlc3RfaWQiOiJGQjM4OjZBMEY6MzJFRTFBRjo0OEFDQjg0OjVCRjMxNjA3IiwidGltZXN0YW1wIjoxNTQyNjU3NTUwLCJob3N0IjoiZ2l0aHViLmNvbSJ9">

    <meta name="enabled-features" content="DASHBOARD_V2_LAYOUT_OPT_IN,EXPLORE_DISCOVER_REPOSITORIES,UNIVERSE_BANNER,MARKETPLACE_PLAN_RESTRICTION_EDITOR,NOTIFY_ON_BLOCK,SAVED_THREADS,SUGGESTED_CHANGES_UX_TEST,SUGGESTED_CHANGES_BATCH,RELATED_ISSUES,MARKETPLACE_INSIGHTS_V2">

  <meta name="html-safe-nonce" content="a0ae94e377b186bcab4009f538e5972684bb44ff">

  <meta http-equiv="x-pjax-version" content="5a3b96f97d901ca7d89a527381e2f79c">
  

      <link href="https://github.com/thomasnield/oreilly_sql_fundamentals_for_data/commits/master.atom" rel="alternate" title="Recent Commits to oreilly_sql_fundamentals_for_data:master" type="application/atom+xml">

  <meta name="go-import" content="github.com/thomasnield/oreilly_sql_fundamentals_for_data git https://github.com/thomasnield/oreilly_sql_fundamentals_for_data.git">

  <meta name="octolytics-dimension-user_id" content="7420801" /><meta name="octolytics-dimension-user_login" content="thomasnield" /><meta name="octolytics-dimension-repository_id" content="93264400" /><meta name="octolytics-dimension-repository_nwo" content="thomasnield/oreilly_sql_fundamentals_for_data" /><meta name="octolytics-dimension-repository_public" content="true" /><meta name="octolytics-dimension-repository_is_fork" content="false" /><meta name="octolytics-dimension-repository_network_root_id" content="93264400" /><meta name="octolytics-dimension-repository_network_root_nwo" content="thomasnield/oreilly_sql_fundamentals_for_data" /><meta name="octolytics-dimension-repository_explore_github_marketplace_ci_cta_shown" content="false" />


    <link rel="canonical" href="https://github.com/thomasnield/oreilly_sql_fundamentals_for_data/blob/master/notes_and_slides/sql_fundamentals_notes.md" data-pjax-transient>


  <meta name="browser-stats-url" content="https://api.github.com/_private/browser/stats">

  <meta name="browser-errors-url" content="https://api.github.com/_private/browser/errors">

  <link rel="mask-icon" href="https://assets-cdn.github.com/pinned-octocat.svg" color="#000000">
  <link rel="icon" type="image/x-icon" class="js-site-favicon" href="https://assets-cdn.github.com/favicon.ico">

<meta name="theme-color" content="#1e2327">


  <meta name="u2f-support" content="true">

  <link rel="manifest" href="/manifest.json" crossOrigin="use-credentials">

  </head>

  <body class="logged-in env-production page-blob">
    

  <div class="position-relative js-header-wrapper ">
    <a href="#start-of-content" tabindex="1" class="p-3 bg-blue text-white show-on-focus js-skip-to-content">Skip to content</a>
    <div id="js-pjax-loader-bar" class="pjax-loader-bar"><div class="progress"></div></div>

    
    
    



        
<header class="Header  f5" role="banner">
  <div class="d-flex flex-justify-between px-3 ">
    <div class="d-flex flex-justify-between ">
      <div class="">
        <a class="header-logo-invertocat" href="https://github.com/" data-hotkey="g d" aria-label="Homepage" data-ga-click="Header, go to dashboard, icon:logo">
  <svg height="32" class="octicon octicon-mark-github" viewBox="0 0 16 16" version="1.1" width="32" aria-hidden="true"><path fill-rule="evenodd" d="M8 0C3.58 0 0 3.58 0 8c0 3.54 2.29 6.53 5.47 7.59.4.07.55-.17.55-.38 0-.19-.01-.82-.01-1.49-2.01.37-2.53-.49-2.69-.94-.09-.23-.48-.94-.82-1.13-.28-.15-.68-.52-.01-.53.63-.01 1.08.58 1.23.82.72 1.21 1.87.87 2.33.66.07-.52.28-.87.51-1.07-1.78-.2-3.64-.89-3.64-3.95 0-.87.31-1.59.82-2.15-.08-.2-.36-1.02.08-2.12 0 0 .67-.21 2.2.82.64-.18 1.32-.27 2-.27.68 0 1.36.09 2 .27 1.53-1.04 2.2-.82 2.2-.82.44 1.1.16 1.92.08 2.12.51.56.82 1.27.82 2.15 0 3.07-1.87 3.75-3.65 3.95.29.25.54.73.54 1.48 0 1.07-.01 1.93-.01 2.2 0 .21.15.46.55.38A8.013 8.013 0 0 0 16 8c0-4.42-3.58-8-8-8z"/></svg>
</a>

      </div>

    </div>

    <div class="HeaderMenu d-flex flex-justify-between flex-auto">
      <nav class="d-flex" aria-label="Global">
            <div class="">
              <div class="header-search scoped-search site-scoped-search js-site-search position-relative js-jump-to"
  role="combobox"
  aria-owns="jump-to-results"
  aria-label="Search or jump to"
  aria-haspopup="listbox"
  aria-expanded="false"
>
  <div class="position-relative">
    <!-- '"` --><!-- </textarea></xmp> --></option></form><form class="js-site-search-form" data-scope-type="Repository" data-scope-id="93264400" data-scoped-search-url="/thomasnield/oreilly_sql_fundamentals_for_data/search" data-unscoped-search-url="/search" action="/thomasnield/oreilly_sql_fundamentals_for_data/search" accept-charset="UTF-8" method="get"><input name="utf8" type="hidden" value="&#x2713;" />
      <label class="form-control header-search-wrapper header-search-wrapper-jump-to position-relative d-flex flex-justify-between flex-items-center js-chromeless-input-container">
        <input type="text"
          class="form-control header-search-input jump-to-field js-jump-to-field js-site-search-focus js-site-search-field is-clearable"
          data-hotkey="s,/"
          name="q"
          value=""
          placeholder="Search or jump to…"
          data-unscoped-placeholder="Search or jump to…"
          data-scoped-placeholder="Search or jump to…"
          autocapitalize="off"
          aria-autocomplete="list"
          aria-controls="jump-to-results"
          aria-label="Search or jump to…"
          data-jump-to-suggestions-path="/_graphql/GetSuggestedNavigationDestinations#csrf-token=M/osFsv5GzsjqFTG+n+CawcylKSA2uiCxkfhnP7rjoPYCtvszF1OpHZDqn0t6pmDifdPIfR+wblSJn+OBF7eYg=="
          spellcheck="false"
          autocomplete="off"
          >
          <input type="hidden" class="js-site-search-type-field" name="type" >
            <img src="https://assets-cdn.github.com/images/search-shortcut-hint.svg" alt="" class="mr-2 header-search-key-slash">

            <div class="Box position-absolute overflow-hidden d-none jump-to-suggestions js-jump-to-suggestions-container">
              <ul class="d-none js-jump-to-suggestions-template-container">
                <li class="d-flex flex-justify-start flex-items-center p-0 f5 navigation-item js-navigation-item" role="option">
                  <a tabindex="-1" class="no-underline d-flex flex-auto flex-items-center p-2 jump-to-suggestions-path js-jump-to-suggestion-path js-navigation-open" href="">
                    <div class="jump-to-octicon js-jump-to-octicon flex-shrink-0 mr-2 text-center d-none">
                      <svg height="16" width="16" class="octicon octicon-repo flex-shrink-0 js-jump-to-octicon-repo d-none" title="Repository" aria-label="Repository" viewBox="0 0 12 16" version="1.1" role="img"><path fill-rule="evenodd" d="M4 9H3V8h1v1zm0-3H3v1h1V6zm0-2H3v1h1V4zm0-2H3v1h1V2zm8-1v12c0 .55-.45 1-1 1H6v2l-1.5-1.5L3 16v-2H1c-.55 0-1-.45-1-1V1c0-.55.45-1 1-1h10c.55 0 1 .45 1 1zm-1 10H1v2h2v-1h3v1h5v-2zm0-10H2v9h9V1z"/></svg>
                      <svg height="16" width="16" class="octicon octicon-project flex-shrink-0 js-jump-to-octicon-project d-none" title="Project" aria-label="Project" viewBox="0 0 15 16" version="1.1" role="img"><path fill-rule="evenodd" d="M10 12h3V2h-3v10zm-4-2h3V2H6v8zm-4 4h3V2H2v12zm-1 1h13V1H1v14zM14 0H1a1 1 0 0 0-1 1v14a1 1 0 0 0 1 1h13a1 1 0 0 0 1-1V1a1 1 0 0 0-1-1z"/></svg>
                      <svg height="16" width="16" class="octicon octicon-search flex-shrink-0 js-jump-to-octicon-search d-none" title="Search" aria-label="Search" viewBox="0 0 16 16" version="1.1" role="img"><path fill-rule="evenodd" d="M15.7 13.3l-3.81-3.83A5.93 5.93 0 0 0 13 6c0-3.31-2.69-6-6-6S1 2.69 1 6s2.69 6 6 6c1.3 0 2.48-.41 3.47-1.11l3.83 3.81c.19.2.45.3.7.3.25 0 .52-.09.7-.3a.996.996 0 0 0 0-1.41v.01zM7 10.7c-2.59 0-4.7-2.11-4.7-4.7 0-2.59 2.11-4.7 4.7-4.7 2.59 0 4.7 2.11 4.7 4.7 0 2.59-2.11 4.7-4.7 4.7z"/></svg>
                    </div>

                    <img class="avatar mr-2 flex-shrink-0 js-jump-to-suggestion-avatar d-none" alt="" aria-label="Team" src="" width="28" height="28">

                    <div class="jump-to-suggestion-name js-jump-to-suggestion-name flex-auto overflow-hidden text-left no-wrap css-truncate css-truncate-target">
                    </div>

                    <div class="border rounded-1 flex-shrink-0 bg-gray px-1 text-gray-light ml-1 f6 d-none js-jump-to-badge-search">
                      <span class="js-jump-to-badge-search-text-default d-none" aria-label="in this repository">
                        In this repository
                      </span>
                      <span class="js-jump-to-badge-search-text-global d-none" aria-label="in all of GitHub">
                        All GitHub
                      </span>
                      <span aria-hidden="true" class="d-inline-block ml-1 v-align-middle">↵</span>
                    </div>

                    <div aria-hidden="true" class="border rounded-1 flex-shrink-0 bg-gray px-1 text-gray-light ml-1 f6 d-none d-on-nav-focus js-jump-to-badge-jump">
                      Jump to
                      <span class="d-inline-block ml-1 v-align-middle">↵</span>
                    </div>
                  </a>
                </li>
              </ul>
              <ul class="d-none js-jump-to-no-results-template-container">
                <li class="d-flex flex-justify-center flex-items-center p-3 f5 d-none">
                  <span class="text-gray">No suggested jump to results</span>
                </li>
              </ul>

              <ul id="jump-to-results" role="listbox" class="js-navigation-container jump-to-suggestions-results-container js-jump-to-suggestions-results-container" >
                <li class="d-flex flex-justify-center flex-items-center p-0 f5">
                  <img src="https://assets-cdn.github.com/images/spinners/octocat-spinner-128.gif" alt="Octocat Spinner Icon" class="m-2" width="28">
                </li>
              </ul>
            </div>
      </label>
</form>  </div>
</div>

            </div>

          <ul class="d-flex pl-2 flex-items-center text-bold list-style-none">
            <li>
              <a class="js-selected-navigation-item HeaderNavlink px-2" data-hotkey="g p" data-ga-click="Header, click, Nav menu - item:pulls context:user" aria-label="Pull requests you created" data-selected-links="/pulls /pulls/assigned /pulls/mentioned /pulls" href="/pulls">
                Pull requests
</a>            </li>
            <li>
              <a class="js-selected-navigation-item HeaderNavlink px-2" data-hotkey="g i" data-ga-click="Header, click, Nav menu - item:issues context:user" aria-label="Issues you created" data-selected-links="/issues /issues/assigned /issues/mentioned /issues" href="/issues">
                Issues
</a>            </li>
              <li class="position-relative">
                <a class="js-selected-navigation-item HeaderNavlink px-2" data-ga-click="Header, click, Nav menu - item:marketplace context:user" data-octo-click="marketplace_click" data-octo-dimensions="location:nav_bar" data-selected-links=" /marketplace" href="/marketplace">
                   Marketplace
</a>                  
              </li>
            <li>
              <a class="js-selected-navigation-item HeaderNavlink px-2" data-ga-click="Header, click, Nav menu - item:explore" data-selected-links="/explore /trending /trending/developers /integrations /integrations/feature/code /integrations/feature/collaborate /integrations/feature/ship showcases showcases_search showcases_landing /explore" href="/explore">
                Explore
</a>            </li>
          </ul>
      </nav>

      <div class="d-flex">
        
<ul class="user-nav d-flex flex-items-center list-style-none" id="user-links">
  <li class="dropdown">
    <span class="d-inline-block  px-2">
      
    <a aria-label="You have unread notifications" class="notification-indicator tooltipped tooltipped-s  js-socket-channel js-notification-indicator" data-hotkey="g n" data-ga-click="Header, go to notifications, icon:unread" data-channel="notification-changed:21145085" href="/notifications">
        <span class="mail-status unread"></span>
        <svg class="octicon octicon-bell" viewBox="0 0 14 16" version="1.1" width="14" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M13.99 11.991v1H0v-1l.73-.58c.769-.769.809-2.547 1.189-4.416.77-3.767 4.077-4.996 4.077-4.996 0-.55.45-1 .999-1 .55 0 1 .45 1 1 0 0 3.387 1.229 4.156 4.996.38 1.879.42 3.657 1.19 4.417l.659.58h-.01zM6.995 15.99c1.11 0 1.999-.89 1.999-1.999H4.996c0 1.11.89 1.999 1.999 1.999z"/></svg>
</a>
    </span>
  </li>

  <li class="dropdown">
    <details class="details-overlay details-reset d-flex px-2 flex-items-center">
      <summary class="HeaderNavlink"
         aria-label="Create new…"
         data-ga-click="Header, create new, icon:add">
        <svg class="octicon octicon-plus float-left mr-1 mt-1" viewBox="0 0 12 16" version="1.1" width="12" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M12 9H7v5H5V9H0V7h5V2h2v5h5v2z"/></svg>
        <span class="dropdown-caret mt-1"></span>
      </summary>
      <details-menu class="dropdown-menu dropdown-menu-sw">
        
<a role="menuitem" class="dropdown-item" href="/new" data-ga-click="Header, create new repository">
  New repository
</a>

  <a role="menuitem" class="dropdown-item" href="/new/import" data-ga-click="Header, import a repository">
    Import repository
  </a>

<a role="menuitem" class="dropdown-item" href="https://gist.github.com/" data-ga-click="Header, create new gist">
  New gist
</a>

  <a role="menuitem" class="dropdown-item" href="/organizations/new" data-ga-click="Header, create new organization">
    New organization
  </a>


  <div class="dropdown-divider"></div>
  <div class="dropdown-header">
    <span title="thomasnield/oreilly_sql_fundamentals_for_data">This repository</span>
  </div>
    <a role="menuitem" class="dropdown-item" href="/thomasnield/oreilly_sql_fundamentals_for_data/issues/new" data-ga-click="Header, create new issue">
      New issue
    </a>


      </details-menu>
    </details>
  </li>

  <li class="dropdown">

    <details class="details-overlay details-reset d-flex pl-2 flex-items-center">
      <summary class="HeaderNavlink name mt-1"
        aria-label="View profile and more"
        data-ga-click="Header, show menu, icon:avatar">
        <img alt="@V-Rajasekar" class="avatar float-left mr-1" src="https://avatars2.githubusercontent.com/u/21145085?s=40&amp;v=4" height="20" width="20">
        <span class="dropdown-caret"></span>
      </summary>
      <details-menu class="dropdown-menu dropdown-menu-sw">
        <ul>
          <li class="header-nav-current-user css-truncate"><a role="menuitem" class="no-underline user-profile-link px-3 pt-2 pb-2 mb-n2 mt-n1 d-block" href="/V-Rajasekar" data-ga-click="Header, go to profile, text:Signed in as">Signed in as <strong class="css-truncate-target">V-Rajasekar</strong></a></li>
          <li class="dropdown-divider"></li>
          <li><a role="menuitem" class="dropdown-item" href="/V-Rajasekar" data-ga-click="Header, go to profile, text:your profile">Your profile</a></li>
          <li><a role="menuitem" class="dropdown-item" href="/V-Rajasekar?tab=repositories" data-ga-click="Header, go to repositories, text:your repositories">Your repositories</a></li>


          <li><a role="menuitem" class="dropdown-item" href="/V-Rajasekar?tab=stars" data-ga-click="Header, go to starred repos, text:your stars">Your stars</a></li>
            <li><a role="menuitem" class="dropdown-item" href="https://gist.github.com/" data-ga-click="Header, your gists, text:your gists">Your gists</a></li>
          <li class="dropdown-divider"></li>
          <li><a role="menuitem" class="dropdown-item" href="https://help.github.com" data-ga-click="Header, go to help, text:help">Help</a></li>
          <li><a role="menuitem" class="dropdown-item" href="/settings/profile" data-ga-click="Header, go to settings, icon:settings">Settings</a></li>
          <li>
            <!-- '"` --><!-- </textarea></xmp> --></option></form><form class="logout-form" action="/logout" accept-charset="UTF-8" method="post"><input name="utf8" type="hidden" value="&#x2713;" /><input type="hidden" name="authenticity_token" value="SDOunnpUoYVX/90NMjjizEpbMNKPuSVIm2QuhX7FIdiAcsQykzZMojGdyfIfNTiimIfKfmg/1FpOadezvUDOqw==" />
              <button type="submit" class="dropdown-item dropdown-signout" data-ga-click="Header, sign out, icon:logout" role="menuitem">
                Sign out
              </button>
</form>          </li>
        </ul>
      </details-menu>
    </details>
  </li>
</ul>



        <!-- '"` --><!-- </textarea></xmp> --></option></form><form class="sr-only right-0" action="/logout" accept-charset="UTF-8" method="post"><input name="utf8" type="hidden" value="&#x2713;" /><input type="hidden" name="authenticity_token" value="6QnlZeXkKzQAm9RjJOWUXRNkLVjOq/okRCh9nTmnbDshSI/JDIbGE2b5wJwJ6E4zwbjX9CktCzaRJYSr+iKDSA==" />
          <button type="submit" class="dropdown-item dropdown-signout" data-ga-click="Header, sign out, icon:logout">
            Sign out
          </button>
</form>      </div>
    </div>
  </div>
</header>

      

  </div>

  <div id="start-of-content" class="show-on-focus"></div>

    <div id="js-flash-container">


</div>



  <div role="main" class="application-main ">
        <div itemscope itemtype="http://schema.org/SoftwareSourceCode" class="">
    <div id="js-repo-pjax-container" data-pjax-container >
      







  <div class="pagehead repohead instapaper_ignore readability-menu experiment-repo-nav  ">
    <div class="repohead-details-container clearfix container">

      <ul class="pagehead-actions">
  <li>
        <!-- '"` --><!-- </textarea></xmp> --></option></form><form data-remote="true" class="js-social-form js-social-container" action="/notifications/subscribe" accept-charset="UTF-8" method="post"><input name="utf8" type="hidden" value="&#x2713;" /><input type="hidden" name="authenticity_token" value="x1msBKUNoe3NK18TFz6IPsI04rpdVA+GvMznsrJ2FcMBSEATjq/3kFrWPmQspNS41fRvLBz60RDldgI5uOfYDA==" />      <input type="hidden" name="repository_id" id="repository_id" value="93264400" class="form-control" />

      <details class="details-reset details-overlay select-menu float-left">
        <summary class="btn btn-sm btn-with-count select-menu-button" data-ga-click="Repository, click Watch settings, action:blob#show">
          <span data-menu-button>
                <svg class="octicon octicon-eye v-align-text-bottom" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M8.06 2C3 2 0 8 0 8s3 6 8.06 6C13 14 16 8 16 8s-3-6-7.94-6zM8 12c-2.2 0-4-1.78-4-4 0-2.2 1.8-4 4-4 2.22 0 4 1.8 4 4 0 2.22-1.78 4-4 4zm2-4c0 1.11-.89 2-2 2-1.11 0-2-.89-2-2 0-1.11.89-2 2-2 1.11 0 2 .89 2 2z"/></svg>
                Watch
          </span>
        </summary>
        <details-menu class="select-menu-modal position-absolute mt-5" style="z-index: 99;">
          <div class="select-menu-header">
            <span class="select-menu-title">Notifications</span>
          </div>
          <div class="select-menu-list">
            <button type="submit" name="do" value="included" class="select-menu-item width-full" aria-checked="true" role="menuitemradio">
              <svg class="octicon octicon-check select-menu-item-icon" viewBox="0 0 12 16" version="1.1" width="12" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M12 5l-8 8-4-4 1.5-1.5L4 10l6.5-6.5L12 5z"/></svg>
              <div class="select-menu-item-text">
                <span class="select-menu-item-heading">Not watching</span>
                <span class="description">Be notified only when participating or @mentioned.</span>
                  <span class="hidden-select-button-text" data-menu-button-contents>
                    <svg class="octicon octicon-eye v-align-text-bottom" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M8.06 2C3 2 0 8 0 8s3 6 8.06 6C13 14 16 8 16 8s-3-6-7.94-6zM8 12c-2.2 0-4-1.78-4-4 0-2.2 1.8-4 4-4 2.22 0 4 1.8 4 4 0 2.22-1.78 4-4 4zm2-4c0 1.11-.89 2-2 2-1.11 0-2-.89-2-2 0-1.11.89-2 2-2 1.11 0 2 .89 2 2z"/></svg>
                    Watch
                  </span>
              </div>
            </button>


            <button type="submit" name="do" value="subscribed" class="select-menu-item width-full" aria-checked="false" role="menuitemradio">
              <svg class="octicon octicon-check select-menu-item-icon" viewBox="0 0 12 16" version="1.1" width="12" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M12 5l-8 8-4-4 1.5-1.5L4 10l6.5-6.5L12 5z"/></svg>
              <div class="select-menu-item-text">
                <span class="select-menu-item-heading">Watching</span>
                <span class="description">Be notified of all conversations.</span>
                  <span class="hidden-select-button-text" data-menu-button-contents>
                    <svg class="octicon octicon-eye v-align-text-bottom" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M8.06 2C3 2 0 8 0 8s3 6 8.06 6C13 14 16 8 16 8s-3-6-7.94-6zM8 12c-2.2 0-4-1.78-4-4 0-2.2 1.8-4 4-4 2.22 0 4 1.8 4 4 0 2.22-1.78 4-4 4zm2-4c0 1.11-.89 2-2 2-1.11 0-2-.89-2-2 0-1.11.89-2 2-2 1.11 0 2 .89 2 2z"/></svg>
                    Unwatch
                  </span>
              </div>
            </button>

            <button type="submit" name="do" value="ignore" class="select-menu-item width-full" aria-checked="false" role="menuitemradio">
              <svg class="octicon octicon-check select-menu-item-icon" viewBox="0 0 12 16" version="1.1" width="12" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M12 5l-8 8-4-4 1.5-1.5L4 10l6.5-6.5L12 5z"/></svg>
              <div class="select-menu-item-text">
                <span class="select-menu-item-heading">Ignoring</span>
                <span class="description">Never be notified.</span>
                  <span class="hidden-select-button-text" data-menu-button-contents>
                    <svg class="octicon octicon-mute v-align-text-bottom" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M8 2.81v10.38c0 .67-.81 1-1.28.53L3 10H1c-.55 0-1-.45-1-1V7c0-.55.45-1 1-1h2l3.72-3.72C7.19 1.81 8 2.14 8 2.81zm7.53 3.22l-1.06-1.06-1.97 1.97-1.97-1.97-1.06 1.06L11.44 8 9.47 9.97l1.06 1.06 1.97-1.97 1.97 1.97 1.06-1.06L13.56 8l1.97-1.97z"/></svg>
                    Stop ignoring
                  </span>
              </div>
            </button>
          </div>
        </details-menu>
      </details>
      <a class="social-count js-social-count"
        href="/thomasnield/oreilly_sql_fundamentals_for_data/watchers"
        aria-label="13 users are watching this repository">
        13
      </a>
</form>
  </li>

  <li>
    
  <div class="js-toggler-container js-social-container starring-container on">
    <!-- '"` --><!-- </textarea></xmp> --></option></form><form class="starred js-social-form" action="/thomasnield/oreilly_sql_fundamentals_for_data/unstar" accept-charset="UTF-8" method="post"><input name="utf8" type="hidden" value="&#x2713;" /><input type="hidden" name="authenticity_token" value="t9mNJkxddN8hpkfngnJoLLWES3+TId8ZflTcws3qmCX31NoJh0rMJK8qjab7P07dJ1G5v3QjjozB9xiRbAN51A==" />
      <input type="hidden" name="context" value="repository"></input>
      <button
        type="submit"
        class="btn btn-sm btn-with-count js-toggler-target"
        aria-label="Unstar this repository" title="Unstar thomasnield/oreilly_sql_fundamentals_for_data"
        data-ga-click="Repository, click unstar button, action:blob#show; text:Unstar">
        <svg class="octicon octicon-star v-align-text-bottom" viewBox="0 0 14 16" version="1.1" width="14" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M14 6l-4.9-.64L7 1 4.9 5.36 0 6l3.6 3.26L2.67 14 7 11.67 11.33 14l-.93-4.74L14 6z"/></svg>
        Unstar
      </button>
        <a class="social-count js-social-count" href="/thomasnield/oreilly_sql_fundamentals_for_data/stargazers"
           aria-label="33 users starred this repository">
          33
        </a>
</form>
    <!-- '"` --><!-- </textarea></xmp> --></option></form><form class="unstarred js-social-form" action="/thomasnield/oreilly_sql_fundamentals_for_data/star" accept-charset="UTF-8" method="post"><input name="utf8" type="hidden" value="&#x2713;" /><input type="hidden" name="authenticity_token" value="TjZvsOJ9GZ77Il1TkY6Ck4gKeGecKTYQe5DIsq2HgfaZvLHYckfiP5MtZRM6hGSyhmO6jTXoE4+XLL/aQ0rMsQ==" />
      <input type="hidden" name="context" value="repository"></input>
      <button
        type="submit"
        class="btn btn-sm btn-with-count js-toggler-target"
        aria-label="Star this repository" title="Star thomasnield/oreilly_sql_fundamentals_for_data"
        data-ga-click="Repository, click star button, action:blob#show; text:Star">
        <svg class="octicon octicon-star v-align-text-bottom" viewBox="0 0 14 16" version="1.1" width="14" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M14 6l-4.9-.64L7 1 4.9 5.36 0 6l3.6 3.26L2.67 14 7 11.67 11.33 14l-.93-4.74L14 6z"/></svg>
        Star
      </button>
        <a class="social-count js-social-count" href="/thomasnield/oreilly_sql_fundamentals_for_data/stargazers"
           aria-label="33 users starred this repository">
          33
        </a>
</form>  </div>

  </li>

  <li>
          <!-- '"` --><!-- </textarea></xmp> --></option></form><form class="btn-with-count" action="/thomasnield/oreilly_sql_fundamentals_for_data/fork" accept-charset="UTF-8" method="post"><input name="utf8" type="hidden" value="&#x2713;" /><input type="hidden" name="authenticity_token" value="2Y46UoDIj22GT49geBQlYAKKf5J/loJlIYWhrRMA6tfXwv6ufBzU1XqQDIV087jVB7tt3swBdMroR7mVNv5Iqg==" />
            <button
                type="submit"
                class="btn btn-sm btn-with-count"
                data-ga-click="Repository, show fork modal, action:blob#show; text:Fork"
                title="Fork your own copy of thomasnield/oreilly_sql_fundamentals_for_data to your account"
                aria-label="Fork your own copy of thomasnield/oreilly_sql_fundamentals_for_data to your account">
              <svg class="octicon octicon-repo-forked v-align-text-bottom" viewBox="0 0 10 16" version="1.1" width="10" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M8 1a1.993 1.993 0 0 0-1 3.72V6L5 8 3 6V4.72A1.993 1.993 0 0 0 2 1a1.993 1.993 0 0 0-1 3.72V6.5l3 3v1.78A1.993 1.993 0 0 0 5 15a1.993 1.993 0 0 0 1-3.72V9.5l3-3V4.72A1.993 1.993 0 0 0 8 1zM2 4.2C1.34 4.2.8 3.65.8 3c0-.65.55-1.2 1.2-1.2.65 0 1.2.55 1.2 1.2 0 .65-.55 1.2-1.2 1.2zm3 10c-.66 0-1.2-.55-1.2-1.2 0-.65.55-1.2 1.2-1.2.65 0 1.2.55 1.2 1.2 0 .65-.55 1.2-1.2 1.2zm3-10c-.66 0-1.2-.55-1.2-1.2 0-.65.55-1.2 1.2-1.2.65 0 1.2.55 1.2 1.2 0 .65-.55 1.2-1.2 1.2z"/></svg>
              Fork
            </button>
</form>
    <a href="/thomasnield/oreilly_sql_fundamentals_for_data/network/members" class="social-count"
       aria-label="23 users forked this repository">
      23
    </a>
  </li>
</ul>

      <h1 class="public ">
  <svg class="octicon octicon-repo" viewBox="0 0 12 16" version="1.1" width="12" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9H3V8h1v1zm0-3H3v1h1V6zm0-2H3v1h1V4zm0-2H3v1h1V2zm8-1v12c0 .55-.45 1-1 1H6v2l-1.5-1.5L3 16v-2H1c-.55 0-1-.45-1-1V1c0-.55.45-1 1-1h10c.55 0 1 .45 1 1zm-1 10H1v2h2v-1h3v1h5v-2zm0-10H2v9h9V1z"/></svg>
  <span class="author" itemprop="author"><a class="url fn" rel="author" data-hovercard-type="user" data-hovercard-url="/hovercards?user_id=7420801" data-octo-click="hovercard-link-click" data-octo-dimensions="link_type:self" href="/thomasnield">thomasnield</a></span><!--
--><span class="path-divider">/</span><!--
--><strong itemprop="name"><a data-pjax="#js-repo-pjax-container" href="/thomasnield/oreilly_sql_fundamentals_for_data">oreilly_sql_fundamentals_for_data</a></strong>

</h1>

    </div>
    
<nav class="reponav js-repo-nav js-sidenav-container-pjax container"
     itemscope
     itemtype="http://schema.org/BreadcrumbList"
    aria-label="Repository"
     data-pjax="#js-repo-pjax-container">

  <span itemscope itemtype="http://schema.org/ListItem" itemprop="itemListElement">
    <a class="js-selected-navigation-item selected reponav-item" itemprop="url" data-hotkey="g c" aria-current="page" data-selected-links="repo_source repo_downloads repo_commits repo_releases repo_tags repo_branches repo_packages /thomasnield/oreilly_sql_fundamentals_for_data" href="/thomasnield/oreilly_sql_fundamentals_for_data">
      <svg class="octicon octicon-code" viewBox="0 0 14 16" version="1.1" width="14" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M9.5 3L8 4.5 11.5 8 8 11.5 9.5 13 14 8 9.5 3zm-5 0L0 8l4.5 5L6 11.5 2.5 8 6 4.5 4.5 3z"/></svg>
      <span itemprop="name">Code</span>
      <meta itemprop="position" content="1">
</a>  </span>

    <span itemscope itemtype="http://schema.org/ListItem" itemprop="itemListElement">
      <a itemprop="url" data-hotkey="g i" class="js-selected-navigation-item reponav-item" data-selected-links="repo_issues repo_labels repo_milestones /thomasnield/oreilly_sql_fundamentals_for_data/issues" href="/thomasnield/oreilly_sql_fundamentals_for_data/issues">
        <svg class="octicon octicon-issue-opened" viewBox="0 0 14 16" version="1.1" width="14" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M7 2.3c3.14 0 5.7 2.56 5.7 5.7s-2.56 5.7-5.7 5.7A5.71 5.71 0 0 1 1.3 8c0-3.14 2.56-5.7 5.7-5.7zM7 1C3.14 1 0 4.14 0 8s3.14 7 7 7 7-3.14 7-7-3.14-7-7-7zm1 3H6v5h2V4zm0 6H6v2h2v-2z"/></svg>
        <span itemprop="name">Issues</span>
        <span class="Counter">0</span>
        <meta itemprop="position" content="2">
</a>    </span>

  <span itemscope itemtype="http://schema.org/ListItem" itemprop="itemListElement">
    <a data-hotkey="g p" itemprop="url" class="js-selected-navigation-item reponav-item" data-selected-links="repo_pulls checks /thomasnield/oreilly_sql_fundamentals_for_data/pulls" href="/thomasnield/oreilly_sql_fundamentals_for_data/pulls">
      <svg class="octicon octicon-git-pull-request" viewBox="0 0 12 16" version="1.1" width="12" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M11 11.28V5c-.03-.78-.34-1.47-.94-2.06C9.46 2.35 8.78 2.03 8 2H7V0L4 3l3 3V4h1c.27.02.48.11.69.31.21.2.3.42.31.69v6.28A1.993 1.993 0 0 0 10 15a1.993 1.993 0 0 0 1-3.72zm-1 2.92c-.66 0-1.2-.55-1.2-1.2 0-.65.55-1.2 1.2-1.2.65 0 1.2.55 1.2 1.2 0 .65-.55 1.2-1.2 1.2zM4 3c0-1.11-.89-2-2-2a1.993 1.993 0 0 0-1 3.72v6.56A1.993 1.993 0 0 0 2 15a1.993 1.993 0 0 0 1-3.72V4.72c.59-.34 1-.98 1-1.72zm-.8 10c0 .66-.55 1.2-1.2 1.2-.65 0-1.2-.55-1.2-1.2 0-.65.55-1.2 1.2-1.2.65 0 1.2.55 1.2 1.2zM2 4.2C1.34 4.2.8 3.65.8 3c0-.65.55-1.2 1.2-1.2.65 0 1.2.55 1.2 1.2 0 .65-.55 1.2-1.2 1.2z"/></svg>
      <span itemprop="name">Pull requests</span>
      <span class="Counter">0</span>
      <meta itemprop="position" content="3">
</a>  </span>


    <a data-hotkey="g b" class="js-selected-navigation-item reponav-item" data-selected-links="repo_projects new_repo_project repo_project /thomasnield/oreilly_sql_fundamentals_for_data/projects" href="/thomasnield/oreilly_sql_fundamentals_for_data/projects">
      <svg class="octicon octicon-project" viewBox="0 0 15 16" version="1.1" width="15" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M10 12h3V2h-3v10zm-4-2h3V2H6v8zm-4 4h3V2H2v12zm-1 1h13V1H1v14zM14 0H1a1 1 0 0 0-1 1v14a1 1 0 0 0 1 1h13a1 1 0 0 0 1-1V1a1 1 0 0 0-1-1z"/></svg>
      Projects
      <span class="Counter" >0</span>
</a>

    <a class="js-selected-navigation-item reponav-item" data-hotkey="g w" data-selected-links="repo_wiki /thomasnield/oreilly_sql_fundamentals_for_data/wiki" href="/thomasnield/oreilly_sql_fundamentals_for_data/wiki">
      <svg class="octicon octicon-book" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M3 5h4v1H3V5zm0 3h4V7H3v1zm0 2h4V9H3v1zm11-5h-4v1h4V5zm0 2h-4v1h4V7zm0 2h-4v1h4V9zm2-6v9c0 .55-.45 1-1 1H9.5l-1 1-1-1H2c-.55 0-1-.45-1-1V3c0-.55.45-1 1-1h5.5l1 1 1-1H15c.55 0 1 .45 1 1zm-8 .5L7.5 3H2v9h6V3.5zm7-.5H9.5l-.5.5V12h6V3z"/></svg>
      Wiki
</a>
  <a class="js-selected-navigation-item reponav-item" data-selected-links="repo_graphs repo_contributors dependency_graph pulse alerts /thomasnield/oreilly_sql_fundamentals_for_data/pulse" href="/thomasnield/oreilly_sql_fundamentals_for_data/pulse">
    <svg class="octicon octicon-graph" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M16 14v1H0V0h1v14h15zM5 13H3V8h2v5zm4 0H7V3h2v10zm4 0h-2V6h2v7z"/></svg>
    Insights
</a>

</nav>


  </div>

<div class="container new-discussion-timeline experiment-repo-nav  ">
  <div class="repository-content ">

    

  
    <a class="d-none js-permalink-shortcut" data-hotkey="y" href="/thomasnield/oreilly_sql_fundamentals_for_data/blob/7c966126fc7b8faec4c9be679e7a8a757039595e/notes_and_slides/sql_fundamentals_notes.md">Permalink</a>

    <!-- blob contrib key: blob_contributors:v21:8eeda041c41d8f7c6e7ae653fc9d06a4 -->

    

    <div class="file-navigation">
      
<div class="select-menu branch-select-menu js-menu-container js-select-menu float-left">
  <button class=" btn btn-sm select-menu-button js-menu-target css-truncate" data-hotkey="w"
    
    type="button" aria-label="Switch branches or tags" aria-expanded="false" aria-haspopup="true">
      <i>Branch:</i>
      <span class="js-select-button css-truncate-target">master</span>
  </button>

  <div class="select-menu-modal-holder js-menu-content js-navigation-container" data-pjax>

    <div class="select-menu-modal">
      <div class="select-menu-header">
        <svg class="octicon octicon-x js-menu-close" role="img" aria-label="Close" viewBox="0 0 12 16" version="1.1" width="12" height="16"><path fill-rule="evenodd" d="M7.48 8l3.75 3.75-1.48 1.48L6 9.48l-3.75 3.75-1.48-1.48L4.52 8 .77 4.25l1.48-1.48L6 6.52l3.75-3.75 1.48 1.48L7.48 8z"/></svg>
        <span class="select-menu-title">Switch branches/tags</span>
      </div>

      <div class="select-menu-filters">
        <div class="select-menu-text-filter">
          <input type="text" aria-label="Filter branches/tags" id="context-commitish-filter-field" class="form-control js-filterable-field js-navigation-enable" placeholder="Filter branches/tags">
        </div>
        <div class="select-menu-tabs" role="tablist">
          <ul>
            <li class="select-menu-tab">
              <a href="#" data-tab-filter="branches" data-filter-placeholder="Filter branches/tags" class="js-select-menu-tab" role="tab">Branches</a>
            </li>
            <li class="select-menu-tab">
              <a href="#" data-tab-filter="tags" data-filter-placeholder="Find a tag…" class="js-select-menu-tab" role="tab">Tags</a>
            </li>
          </ul>
        </div>
      </div>

      <div class="select-menu-list select-menu-tab-bucket js-select-menu-tab-bucket" data-tab-filter="branches" role="menu">

        <div data-filterable-for="context-commitish-filter-field" data-filterable-type="substring">


            <a class="select-menu-item js-navigation-item js-navigation-open selected"
               href="/thomasnield/oreilly_sql_fundamentals_for_data/blob/master/notes_and_slides/sql_fundamentals_notes.md"
               data-name="master"
               data-skip-pjax="true"
               rel="nofollow">
              <svg class="octicon octicon-check select-menu-item-icon" viewBox="0 0 12 16" version="1.1" width="12" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M12 5l-8 8-4-4 1.5-1.5L4 10l6.5-6.5L12 5z"/></svg>
              <span class="select-menu-item-text css-truncate-target js-select-menu-filter-text">
                master
              </span>
            </a>
        </div>

          <div class="select-menu-no-results">Nothing to show</div>
      </div>

      <div class="select-menu-list select-menu-tab-bucket js-select-menu-tab-bucket" data-tab-filter="tags">
        <div data-filterable-for="context-commitish-filter-field" data-filterable-type="substring">


        </div>

        <div class="select-menu-no-results">Nothing to show</div>
      </div>

    </div>
  </div>
</div>

      <div class="BtnGroup float-right">
        <a href="/thomasnield/oreilly_sql_fundamentals_for_data/find/master"
              class="js-pjax-capture-input btn btn-sm BtnGroup-item"
              data-pjax
              data-hotkey="t">
          Find file
        </a>
        <clipboard-copy for="blob-path" class="btn btn-sm BtnGroup-item">
          Copy path
        </clipboard-copy>
      </div>
      <div id="blob-path" class="breadcrumb">
        <span class="repo-root js-repo-root"><span class="js-path-segment"><a data-pjax="true" href="/thomasnield/oreilly_sql_fundamentals_for_data"><span>oreilly_sql_fundamentals_for_data</span></a></span></span><span class="separator">/</span><span class="js-path-segment"><a data-pjax="true" href="/thomasnield/oreilly_sql_fundamentals_for_data/tree/master/notes_and_slides"><span>notes_and_slides</span></a></span><span class="separator">/</span><strong class="final-path">sql_fundamentals_notes.md</strong>
      </div>
    </div>


    
  <div class="commit-tease">
      <span class="float-right">
        <a class="commit-tease-sha" href="/thomasnield/oreilly_sql_fundamentals_for_data/commit/7c966126fc7b8faec4c9be679e7a8a757039595e" data-pjax>
          7c96612
        </a>
        <relative-time datetime="2018-03-14T14:54:58Z">Mar 14, 2018</relative-time>
      </span>
      <div>
        <a rel="author" data-skip-pjax="true" data-hovercard-type="user" data-hovercard-url="/hovercards?user_id=7420801" data-octo-click="hovercard-link-click" data-octo-dimensions="link_type:self" href="/thomasnield"><img class="avatar" src="https://avatars3.githubusercontent.com/u/7420801?s=40&amp;v=4" width="20" height="20" alt="@thomasnield" /></a>
        <a class="user-mention" rel="author" data-hovercard-type="user" data-hovercard-url="/hovercards?user_id=7420801" data-octo-click="hovercard-link-click" data-octo-dimensions="link_type:self" href="/thomasnield">thomasnield</a>
          <a data-pjax="true" title="improve null case trick exercise" class="message" href="/thomasnield/oreilly_sql_fundamentals_for_data/commit/7c966126fc7b8faec4c9be679e7a8a757039595e">improve null case trick exercise</a>
      </div>

    <div class="commit-tease-contributors">
      
<details class="details-reset details-overlay details-overlay-dark lh-default text-gray-dark float-left mr-2" id="blob_contributors_box">
  <summary class="btn-link" aria-haspopup="dialog"  >
    
    <span><strong>1</strong> contributor</span>
  </summary>
  <details-dialog class="Box Box--overlay d-flex flex-column anim-fade-in fast " aria-label="Users who have contributed to this file">
    <div class="Box-header">
      <button class="Box-btn-octicon btn-octicon float-right" type="button" aria-label="Close dialog" data-close-dialog>
        <svg class="octicon octicon-x" viewBox="0 0 12 16" version="1.1" width="12" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M7.48 8l3.75 3.75-1.48 1.48L6 9.48l-3.75 3.75-1.48-1.48L4.52 8 .77 4.25l1.48-1.48L6 6.52l3.75-3.75 1.48 1.48L7.48 8z"/></svg>
      </button>
      <h3 class="Box-title">Users who have contributed to this file</h3>
    </div>
    
        <ul class="list-style-none overflow-auto">
            <li class="Box-row">
              <a class="link-gray-dark no-underline" href="/thomasnield">
                <img class="avatar mr-2" alt="" src="https://avatars3.githubusercontent.com/u/7420801?s=40&amp;v=4" width="20" height="20" />
                thomasnield
</a>            </li>
        </ul>

  </details-dialog>
</details>
      
    </div>
  </div>



    <div class="file ">
      <div class="file-header">
  <div class="file-actions">


    <div class="BtnGroup">
      <a id="raw-url" class="btn btn-sm BtnGroup-item" href="/thomasnield/oreilly_sql_fundamentals_for_data/raw/master/notes_and_slides/sql_fundamentals_notes.md">Raw</a>
        <a class="btn btn-sm js-update-url-with-hash BtnGroup-item" data-hotkey="b" href="/thomasnield/oreilly_sql_fundamentals_for_data/blame/master/notes_and_slides/sql_fundamentals_notes.md">Blame</a>
      <a rel="nofollow" class="btn btn-sm BtnGroup-item" href="/thomasnield/oreilly_sql_fundamentals_for_data/commits/master/notes_and_slides/sql_fundamentals_notes.md">History</a>
    </div>

        <a class="btn-octicon tooltipped tooltipped-nw"
           href="https://desktop.github.com"
           aria-label="Open this file in GitHub Desktop"
           data-ga-click="Repository, open with desktop, type:windows">
            <svg class="octicon octicon-device-desktop" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M15 2H1c-.55 0-1 .45-1 1v9c0 .55.45 1 1 1h5.34c-.25.61-.86 1.39-2.34 2h8c-1.48-.61-2.09-1.39-2.34-2H15c.55 0 1-.45 1-1V3c0-.55-.45-1-1-1zm0 9H1V3h14v8z"/></svg>
        </a>

          <!-- '"` --><!-- </textarea></xmp> --></option></form><form class="inline-form js-update-url-with-hash" action="/thomasnield/oreilly_sql_fundamentals_for_data/edit/master/notes_and_slides/sql_fundamentals_notes.md" accept-charset="UTF-8" method="post"><input name="utf8" type="hidden" value="&#x2713;" /><input type="hidden" name="authenticity_token" value="YwMzjGv0NQEWQHl0ix1YW1Ww92l6aHeoOoh9ED8ILfAgts8NZZPTWZufm5tbV0EEYVcfHs9hhHp55istQKa0/g==" />
            <button class="btn-octicon tooltipped tooltipped-nw" type="submit"
              aria-label="Fork this project and edit the file" data-hotkey="e" data-disable-with>
              <svg class="octicon octicon-pencil" viewBox="0 0 14 16" version="1.1" width="14" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M0 12v3h3l8-8-3-3-8 8zm3 2H1v-2h1v1h1v1zm10.3-9.3L12 6 9 3l1.3-1.3a.996.996 0 0 1 1.41 0l1.59 1.59c.39.39.39 1.02 0 1.41z"/></svg>
            </button>
</form>
        <!-- '"` --><!-- </textarea></xmp> --></option></form><form class="inline-form" action="/thomasnield/oreilly_sql_fundamentals_for_data/delete/master/notes_and_slides/sql_fundamentals_notes.md" accept-charset="UTF-8" method="post"><input name="utf8" type="hidden" value="&#x2713;" /><input type="hidden" name="authenticity_token" value="WESMVPczRuaGB2uWAY6keS+DdhgrXBXhtKUdcGxDXOPniesRebQwMxPRvLuvXiwQTLyx7HFCcF5QLbAJ5rEG4A==" />
          <button class="btn-octicon btn-octicon-danger tooltipped tooltipped-nw" type="submit"
            aria-label="Fork this project and delete the file" data-disable-with>
            <svg class="octicon octicon-trashcan" viewBox="0 0 12 16" version="1.1" width="12" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M11 2H9c0-.55-.45-1-1-1H5c-.55 0-1 .45-1 1H2c-.55 0-1 .45-1 1v1c0 .55.45 1 1 1v9c0 .55.45 1 1 1h7c.55 0 1-.45 1-1V5c.55 0 1-.45 1-1V3c0-.55-.45-1-1-1zm-1 12H3V5h1v8h1V5h1v8h1V5h1v8h1V5h1v9zm1-10H2V3h9v1z"/></svg>
          </button>
</form>  </div>

  <div class="file-info">
      1223 lines (851 sloc)
      <span class="file-info-divider"></span>
    29.8 KB
  </div>
</div>

      
  <div id="readme" class="readme blob instapaper_body">
    <article class="markdown-body entry-content" itemprop="text"><h1><a id="user-content-section-iii---select" class="anchor" aria-hidden="true" href="#section-iii---select"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>Section III - SELECT</h1>
<h3><a id="user-content-31-selecting-all-columns" class="anchor" aria-hidden="true" href="#31-selecting-all-columns"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>3.1: Selecting all columns</h3>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> <span class="pl-k">*</span> <span class="pl-k">FROM</span> CUSTOMER;</pre></div>
<p>To limit the number of records returned, use a LIMIT. To limit the results to just 2 records:</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> <span class="pl-k">*</span> <span class="pl-k">FROM</span> CUSTOMER <span class="pl-k">LIMIT</span> <span class="pl-c1">2</span>;</pre></div>
<h3><a id="user-content-32-selecting-specific-columns" class="anchor" aria-hidden="true" href="#32-selecting-specific-columns"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>3.2: Selecting specific columns</h3>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> CUSTOMER_ID, NAME <span class="pl-k">FROM</span> CUSTOMER;</pre></div>
<h3><a id="user-content-33-expressions" class="anchor" aria-hidden="true" href="#33-expressions"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>3.3: Expressions</h3>
<p>First, select everything from <code>PRODUCT</code></p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> <span class="pl-k">*</span> <span class="pl-k">FROM</span> PRODUCT;</pre></div>
<p>You can use expressions by declaring a <code>TAXED_PRICE</code>. This is not a column, but rather something that is calculated every time this query is executed.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> PRODUCT_ID,
DESCRIPTION,
PRICE,
PRICE <span class="pl-k">*</span> <span class="pl-c1">1</span>.<span class="pl-c1">07</span> <span class="pl-k">AS</span> TAXED_PRICE
<span class="pl-k">FROM</span> PRODUCT;</pre></div>
<blockquote>
<p>In SQliteStudio, you can hit CTRL + SPACE on Windows and Linux to show an autocomplete box with available fields. For Mac, you will need to enable that configuration in preferences.</p>
</blockquote>
<p>You can also use aliases to declare an <code>UNTAXED_PRICE</code> column off the <code>PRICE</code>, without any expression.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> PRODUCT_ID,
DESCRIPTION,
PRICE <span class="pl-k">as</span> UNTAXED_PRICE,
PRICE <span class="pl-k">*</span> <span class="pl-c1">1</span>.<span class="pl-c1">07</span> <span class="pl-k">AS</span> TAXED_PRICE
<span class="pl-k">FROM</span> PRODUCT;</pre></div>
<p><strong>SWITCH TO SLIDES</strong> FOR MATHEMATICAL OPERATORS</p>
<h3><a id="user-content-34-using-round-function" class="anchor" aria-hidden="true" href="#34-using-round-function"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>3.4: Using <code>round()</code> Function</h3>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> PRODUCT_ID,
DESCRIPTION,
PRICE,
round(PRICE <span class="pl-k">*</span> <span class="pl-c1">1</span>.<span class="pl-c1">07</span>, <span class="pl-c1">2</span>) <span class="pl-k">AS</span> TAXED_PRICE

<span class="pl-k">FROM</span> PRODUCT;</pre></div>
<h3><a id="user-content-35-text-concatenation" class="anchor" aria-hidden="true" href="#35-text-concatenation"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>3.5: Text Concatenation</h3>
<p>You can slap a dollar sign to our result using concatenation.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> PRODUCT_ID,
DESCRIPTION,
PRICE <span class="pl-k">AS</span> UNTAXED_PRICE,
<span class="pl-s"><span class="pl-pds">'</span>$<span class="pl-pds">'</span></span> <span class="pl-k">||</span> round(PRICE <span class="pl-k">*</span> <span class="pl-c1">1</span>.<span class="pl-c1">07</span>, <span class="pl-c1">2</span>) <span class="pl-k">AS</span> TAXED_PRICE
<span class="pl-k">FROM</span> PRODUCT</pre></div>
<p>You can merge text via concatenation. For instance, you can concatenate two fields and put a comma and space <code> ,</code> in between.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> NAME,
CITY <span class="pl-k">||</span> <span class="pl-s"><span class="pl-pds">'</span>, <span class="pl-pds">'</span></span> <span class="pl-k">||</span> STATE <span class="pl-k">AS</span> LOCATION
<span class="pl-k">FROM</span> CUSTOMER;</pre></div>
<p>You can concatenate several fields to create an address.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> NAME,
STREET_ADDRESS <span class="pl-k">||</span> <span class="pl-s"><span class="pl-pds">'</span> <span class="pl-pds">'</span></span> <span class="pl-k">||</span> CITY <span class="pl-k">||</span> <span class="pl-s"><span class="pl-pds">'</span>, <span class="pl-pds">'</span></span> <span class="pl-k">||</span> STATE <span class="pl-k">||</span> <span class="pl-s"><span class="pl-pds">'</span> <span class="pl-pds">'</span></span> <span class="pl-k">||</span> ZIP <span class="pl-k">AS</span> SHIP_ADDRESS
<span class="pl-k">FROM</span> CUSTOMER;</pre></div>
<p>This works with any data types, like numbers, texts, and dates. Also note that some platforms use <code>concat()</code> function instead of double pipes <code>||</code></p>
<p><strong>SWITCH TO SLIDES</strong> FOR EXERCISE</p>
<h2><a id="user-content-36-comments" class="anchor" aria-hidden="true" href="#36-comments"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>3.6: Comments</h2>
<p>To make a comments in SQL, use commenting dashes or blocks:</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-c"><span class="pl-c">--</span> this is a comment</span>

<span class="pl-c"><span class="pl-c">/*</span></span>
<span class="pl-c">This is a</span>
<span class="pl-c">multiline comment</span>
<span class="pl-c"><span class="pl-c">*/</span></span></pre></div>
<h2><a id="user-content-section-iv--where" class="anchor" aria-hidden="true" href="#section-iv--where"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>Section IV- WHERE</h2>
<h3><a id="user-content-41-getting-year-2010-records" class="anchor" aria-hidden="true" href="#41-getting-year-2010-records"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>4.1: Getting year 2010 records</h3>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> <span class="pl-k">*</span> <span class="pl-k">FROM</span> station_data
<span class="pl-k">WHERE</span> year <span class="pl-k">=</span> <span class="pl-c1">2010</span>;</pre></div>
<h3><a id="user-content-42-getting-non-2010-records" class="anchor" aria-hidden="true" href="#42-getting-non-2010-records"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>4.2: Getting non-2010 records</h3>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> <span class="pl-k">*</span> <span class="pl-k">FROM</span> station_data
<span class="pl-k">WHERE</span> year <span class="pl-k">!=</span> <span class="pl-c1">2010</span>;</pre></div>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> <span class="pl-k">*</span> <span class="pl-k">FROM</span> station_data
<span class="pl-k">WHERE</span> year <span class="pl-k">&lt;&gt;</span> <span class="pl-c1">2010</span>;</pre></div>
<h3><a id="user-content-43-getting-records-between-2005-and-2010" class="anchor" aria-hidden="true" href="#43-getting-records-between-2005-and-2010"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>4.3: Getting records between 2005 and 2010</h3>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> <span class="pl-k">*</span> <span class="pl-k">FROM</span> station_data
<span class="pl-k">WHERE</span> year BETWEEN <span class="pl-c1">2005</span> <span class="pl-k">AND</span> <span class="pl-c1">2010</span></pre></div>
<h3><a id="user-content-44-using-and" class="anchor" aria-hidden="true" href="#44-using-and"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>4.4: Using <code>AND</code></h3>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> <span class="pl-k">*</span> <span class="pl-k">FROM</span> station_data
<span class="pl-k">WHERE</span> year <span class="pl-k">&gt;=</span> <span class="pl-c1">2005</span> <span class="pl-k">AND</span> year <span class="pl-k">&lt;=</span> <span class="pl-c1">2010</span></pre></div>
<h3><a id="user-content-45-exclusive-range" class="anchor" aria-hidden="true" href="#45-exclusive-range"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>4.5: Exclusive Range</h3>
<p>This will get the years between 2005 and 2010, but exclude 2005 and 2010</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> <span class="pl-k">*</span> <span class="pl-k">FROM</span> station_data
<span class="pl-k">WHERE</span> year <span class="pl-k">&gt;</span> <span class="pl-c1">2005</span> <span class="pl-k">AND</span> year <span class="pl-k">&lt;</span> <span class="pl-c1">2010</span></pre></div>
<h3><a id="user-content-46-using-or" class="anchor" aria-hidden="true" href="#46-using-or"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>4.6: Using <code>OR</code></h3>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> <span class="pl-k">*</span> <span class="pl-k">FROM</span> station_data
<span class="pl-k">WHERE</span> MONTH <span class="pl-k">=</span> <span class="pl-c1">3</span>
<span class="pl-k">OR</span> MONTH <span class="pl-k">=</span> <span class="pl-c1">6</span>
<span class="pl-k">OR</span> MONTH <span class="pl-k">=</span> <span class="pl-c1">9</span>
<span class="pl-k">OR</span> MONTH <span class="pl-k">=</span> <span class="pl-c1">12</span></pre></div>
<h3><a id="user-content-47-using-in" class="anchor" aria-hidden="true" href="#47-using-in"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>4.7: Using <code>IN</code></h3>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> <span class="pl-k">*</span> <span class="pl-k">FROM</span> station_data
<span class="pl-k">WHERE</span> MONTH <span class="pl-k">IN</span> (<span class="pl-c1">3</span>,<span class="pl-c1">6</span>,<span class="pl-c1">9</span>,<span class="pl-c1">12</span>);</pre></div>
<h3><a id="user-content-48-using-not-in" class="anchor" aria-hidden="true" href="#48-using-not-in"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>4.8: Using <code>NOT IN</code></h3>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> <span class="pl-k">*</span> <span class="pl-k">FROM</span> station_data
<span class="pl-k">WHERE</span> MONTH NOT <span class="pl-k">IN</span> (<span class="pl-c1">3</span>,<span class="pl-c1">6</span>,<span class="pl-c1">9</span>,<span class="pl-c1">12</span>);</pre></div>
<h3><a id="user-content-49-using-modulus" class="anchor" aria-hidden="true" href="#49-using-modulus"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>4.9: Using Modulus</h3>
<p>The modulus will perform division but return the remainder. So a remainder of 0 means the two numbers divide evenly.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> <span class="pl-k">*</span> <span class="pl-k">FROM</span> station_data
<span class="pl-k">WHERE</span> MONTH % <span class="pl-c1">3</span> <span class="pl-k">=</span> <span class="pl-c1">0</span>;</pre></div>
<h3><a id="user-content-410-using-where-on-text" class="anchor" aria-hidden="true" href="#410-using-where-on-text"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>4.10: Using <code>WHERE</code> on TEXT</h3>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> <span class="pl-k">*</span> <span class="pl-k">FROM</span> station_data
<span class="pl-k">WHERE</span> report_code <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">'</span>513A63<span class="pl-pds">'</span></span></pre></div>
<h3><a id="user-content-411-using-in-with-text" class="anchor" aria-hidden="true" href="#411-using-in-with-text"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>4.11: Using <code>IN</code> with text</h3>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> <span class="pl-k">*</span> <span class="pl-k">FROM</span> station_data
<span class="pl-k">WHERE</span> report_code <span class="pl-k">IN</span> (<span class="pl-s"><span class="pl-pds">'</span>513A63<span class="pl-pds">'</span></span>,<span class="pl-s"><span class="pl-pds">'</span>1F8A7B<span class="pl-pds">'</span></span>,<span class="pl-s"><span class="pl-pds">'</span>EF616A<span class="pl-pds">'</span></span>)</pre></div>
<h3><a id="user-content-412-using-length-function" class="anchor" aria-hidden="true" href="#412-using-length-function"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>4.12: Using <code>length()</code> function</h3>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> <span class="pl-k">*</span> <span class="pl-k">FROM</span> station_data
<span class="pl-k">WHERE</span> length(report_code) <span class="pl-k">!=</span> <span class="pl-c1">6</span></pre></div>
<h3><a id="user-content-413a-using-like-for-any-characters" class="anchor" aria-hidden="true" href="#413a-using-like-for-any-characters"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>4.13A: Using <code>LIKE</code> for any characters</h3>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> <span class="pl-k">*</span> <span class="pl-k">FROM</span> station_data
<span class="pl-k">WHERE</span> report_code <span class="pl-k">LIKE</span> <span class="pl-s"><span class="pl-pds">'</span>A%<span class="pl-pds">'</span></span>;</pre></div>
<h3><a id="user-content-413b-using-regular-expressions" class="anchor" aria-hidden="true" href="#413b-using-regular-expressions"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>4.13B: Using Regular Expressions</h3>
<p>If you are familiar with regular expressions, you can use those to identify and qualify text patterns.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> <span class="pl-k">*</span> <span class="pl-k">FROM</span> STATION_DATA
<span class="pl-k">WHERE</span> report_code REGEXP <span class="pl-s"><span class="pl-pds">'</span>^A.*$<span class="pl-pds">'</span></span></pre></div>
<h3><a id="user-content-414-using-like-for-one-character" class="anchor" aria-hidden="true" href="#414-using-like-for-one-character"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>4.14: Using <code>LIKE</code> for one character</h3>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> <span class="pl-k">*</span> <span class="pl-k">FROM</span> station_data
<span class="pl-k">WHERE</span> report_code <span class="pl-k">LIKE</span> <span class="pl-s"><span class="pl-pds">'</span>B_C%<span class="pl-pds">'</span></span>;</pre></div>
<blockquote>
<p>For <code>LIKE</code>, <code>%</code> is used in a different context than modulus <code>%</code></p>
</blockquote>
<h3><a id="user-content-415-true-booleans-1" class="anchor" aria-hidden="true" href="#415-true-booleans-1"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>4.15: True Booleans 1</h3>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> <span class="pl-k">*</span> <span class="pl-k">FROM</span> station_data
<span class="pl-k">WHERE</span> tornado <span class="pl-k">=</span> <span class="pl-c1">1</span> <span class="pl-k">AND</span> hail <span class="pl-k">=</span> <span class="pl-c1">1</span>;</pre></div>
<h3><a id="user-content-416-true-booleans-2" class="anchor" aria-hidden="true" href="#416-true-booleans-2"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>4.16: True Booleans 2</h3>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> <span class="pl-k">*</span> <span class="pl-k">FROM</span> station_data
<span class="pl-k">WHERE</span> tornado <span class="pl-k">AND</span> hail</pre></div>
<h3><a id="user-content-417-false-booleans-1" class="anchor" aria-hidden="true" href="#417-false-booleans-1"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>4.17: False Booleans 1</h3>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> <span class="pl-k">*</span> <span class="pl-k">FROM</span> station_data
<span class="pl-k">WHERE</span> tornado <span class="pl-k">=</span> <span class="pl-c1">0</span> <span class="pl-k">AND</span> hail <span class="pl-k">=</span> <span class="pl-c1">1</span>;</pre></div>
<h3><a id="user-content-418-false-booleans-2" class="anchor" aria-hidden="true" href="#418-false-booleans-2"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>4.18: False Booleans 2</h3>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> <span class="pl-k">*</span> <span class="pl-k">FROM</span> station_data
<span class="pl-k">WHERE</span> NOT tornado <span class="pl-k">AND</span> hail;</pre></div>
<h3><a id="user-content-419-handling-null" class="anchor" aria-hidden="true" href="#419-handling-null"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>4.19: Handling <code>NULL</code></h3>
<p>A <code>NULL</code> is an absent value. It is not zero, empty text ' ', or any value. It is blank.</p>
<p>To check for a null value:</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> <span class="pl-k">*</span> <span class="pl-k">FROM</span> station_data
<span class="pl-k">WHERE</span> snow_depth IS <span class="pl-k">NULL</span>;</pre></div>
<h3><a id="user-content-420-handling-null-in-conditions" class="anchor" aria-hidden="true" href="#420-handling-null-in-conditions"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>4.20: Handling <code>NULL</code> in conditions</h3>
<p>Nulls will not qualify with any condition that doesn't explicitly handle it.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> <span class="pl-k">*</span> <span class="pl-k">FROM</span> station_data
<span class="pl-k">WHERE</span> precipitation <span class="pl-k">&lt;=</span> <span class="pl-c1">0</span>.<span class="pl-c1">5</span>;</pre></div>
<p>If you want to include nulls, do this:</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> <span class="pl-k">*</span> <span class="pl-k">FROM</span> station_data
<span class="pl-k">WHERE</span> precipitation IS <span class="pl-k">NULL</span> <span class="pl-k">OR</span> precipitation <span class="pl-k">&lt;=</span> <span class="pl-c1">0</span>.<span class="pl-c1">5</span>;</pre></div>
<p>You can also use a <code>coalesce()</code> function to turn a null value into a default value, if it indeed is null.</p>
<p>This will treat all null values as a 0.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> <span class="pl-k">*</span> <span class="pl-k">FROM</span> station_data
<span class="pl-k">WHERE</span> coalesce(precipitation, <span class="pl-c1">0</span>) <span class="pl-k">&lt;=</span> <span class="pl-c1">0</span>.<span class="pl-c1">5</span>;</pre></div>
<h3><a id="user-content-421-combining-and-and-or" class="anchor" aria-hidden="true" href="#421-combining-and-and-or"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>4.21: Combining <code>AND</code> and <code>OR</code></h3>
<p>Querying for sleet or snow</p>
<p>Problematic. What belongs to the <code>AND</code> and what belongs to the <code>OR</code>?</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> <span class="pl-k">*</span> <span class="pl-k">FROM</span> station_data
<span class="pl-k">WHERE</span> rain <span class="pl-k">=</span> <span class="pl-c1">1</span> <span class="pl-k">AND</span> temperature <span class="pl-k">&lt;=</span> <span class="pl-c1">32</span>
<span class="pl-k">OR</span> snow_depth <span class="pl-k">&gt;</span> <span class="pl-c1">0</span>;</pre></div>
<p>You must group up the sleet condition in parenthesis so it is treated as one unit.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> <span class="pl-k">*</span> <span class="pl-k">FROM</span> station_data
<span class="pl-k">WHERE</span> (rain <span class="pl-k">=</span> <span class="pl-c1">1</span> <span class="pl-k">AND</span> temperature <span class="pl-k">&lt;=</span> <span class="pl-c1">32</span>)
<span class="pl-k">OR</span> snow_depth <span class="pl-k">&gt;</span> <span class="pl-c1">0</span>;</pre></div>
<h1><a id="user-content-section-v--group-by-and-order-by" class="anchor" aria-hidden="true" href="#section-v--group-by-and-order-by"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>Section V- GROUP BY and ORDER BY</h1>
<h3><a id="user-content-51-getting-a-count-of-records" class="anchor" aria-hidden="true" href="#51-getting-a-count-of-records"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>5.1: Getting a count of records</h3>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> <span class="pl-c1">count</span>(<span class="pl-k">*</span>) <span class="pl-k">as</span> record_count <span class="pl-k">FROM</span> station_data</pre></div>
<h3><a id="user-content-52-getting-a-count-of-records-with-a-condition" class="anchor" aria-hidden="true" href="#52-getting-a-count-of-records-with-a-condition"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>5.2 Getting a count of records with a condition</h3>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> <span class="pl-c1">count</span>(<span class="pl-k">*</span>) <span class="pl-k">as</span> record_count <span class="pl-k">FROM</span> station_data
<span class="pl-k">WHERE</span> tornado <span class="pl-k">=</span> <span class="pl-c1">1</span></pre></div>
<h3><a id="user-content-53-getting-a-count-by-year" class="anchor" aria-hidden="true" href="#53-getting-a-count-by-year"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>5.3 Getting a count by year</h3>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> year, <span class="pl-c1">count</span>(<span class="pl-k">*</span>) <span class="pl-k">as</span> record_count
<span class="pl-k">FROM</span> station_data
<span class="pl-k">WHERE</span> tornado <span class="pl-k">=</span> <span class="pl-c1">1</span>
<span class="pl-k">GROUP BY</span> year</pre></div>
<h3><a id="user-content-54-getting-a-count-by-year-month" class="anchor" aria-hidden="true" href="#54-getting-a-count-by-year-month"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>5.4 Getting a count by year, month</h3>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> year, month, <span class="pl-c1">count</span>(<span class="pl-k">*</span>) <span class="pl-k">as</span> record_count
<span class="pl-k">FROM</span> station_data
<span class="pl-k">WHERE</span> tornado <span class="pl-k">=</span> <span class="pl-c1">1</span>
<span class="pl-k">GROUP BY</span> year, month</pre></div>
<h3><a id="user-content-55-getting-a-count-by-year-month-with-ordinal-index" class="anchor" aria-hidden="true" href="#55-getting-a-count-by-year-month-with-ordinal-index"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>5.5 Getting a count by year, month with ordinal index</h3>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> year, month, <span class="pl-c1">count</span>(<span class="pl-k">*</span>) <span class="pl-k">as</span> record_count
<span class="pl-k">FROM</span> station_data
<span class="pl-k">WHERE</span> tornado <span class="pl-k">=</span> <span class="pl-c1">1</span>
<span class="pl-k">GROUP BY</span> <span class="pl-c1">1</span>, <span class="pl-c1">2</span></pre></div>
<h3><a id="user-content-56-using-order-by" class="anchor" aria-hidden="true" href="#56-using-order-by"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>5.6 Using ORDER BY</h3>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> year, month, <span class="pl-c1">count</span>(<span class="pl-k">*</span>) <span class="pl-k">as</span> record_count
<span class="pl-k">FROM</span> station_data
<span class="pl-k">WHERE</span> tornado <span class="pl-k">=</span> <span class="pl-c1">1</span>
<span class="pl-k">GROUP BY</span> year, month
<span class="pl-k">ORDER BY</span> year, month</pre></div>
<h3><a id="user-content-57-using-order-by-with-desc" class="anchor" aria-hidden="true" href="#57-using-order-by-with-desc"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>5.7 Using ORDER BY with DESC</h3>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> year, month, <span class="pl-c1">count</span>(<span class="pl-k">*</span>) <span class="pl-k">as</span> record_count
<span class="pl-k">FROM</span> station_data
<span class="pl-k">WHERE</span> tornado <span class="pl-k">=</span> <span class="pl-c1">1</span>
<span class="pl-k">GROUP BY</span> year, month
<span class="pl-k">ORDER BY</span> year <span class="pl-k">DESC</span>, month</pre></div>
<h3><a id="user-content-58-counting-non-null-values" class="anchor" aria-hidden="true" href="#58-counting-non-null-values"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>5.8 Counting non-null values</h3>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> <span class="pl-c1">COUNT</span>(snow_depth) <span class="pl-k">as</span> recorded_snow_depth_count
<span class="pl-k">FROM</span> station_data</pre></div>
<h3><a id="user-content-59-average-temperature-by-month-since-year-2000" class="anchor" aria-hidden="true" href="#59-average-temperature-by-month-since-year-2000"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>5.9 Average temperature by month since year 2000</h3>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> month, <span class="pl-c1">AVG</span>(temperature) <span class="pl-k">as</span> avg_temp
<span class="pl-k">FROM</span> station_data
<span class="pl-k">WHERE</span> year <span class="pl-k">&gt;=</span> <span class="pl-c1">2000</span>
<span class="pl-k">GROUP BY</span> month</pre></div>
<h3><a id="user-content-510-average-temperature-with-rounding-by-month-since-year-2000" class="anchor" aria-hidden="true" href="#510-average-temperature-with-rounding-by-month-since-year-2000"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>5.10 Average temperature (with rounding) by month since year 2000</h3>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> month, round(<span class="pl-c1">AVG</span>(temperature),<span class="pl-c1">2</span>) <span class="pl-k">as</span> avg_temp
<span class="pl-k">FROM</span> station_data
<span class="pl-k">WHERE</span> year <span class="pl-k">&gt;=</span> <span class="pl-c1">2000</span>
<span class="pl-k">GROUP BY</span> month</pre></div>
<h3><a id="user-content-511-sum-of-snow-depth" class="anchor" aria-hidden="true" href="#511-sum-of-snow-depth"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>5.11 Sum of snow depth</h3>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> year, <span class="pl-c1">SUM</span>(snow_depth) <span class="pl-k">as</span> total_snow
<span class="pl-k">FROM</span> station_data
<span class="pl-k">WHERE</span> year <span class="pl-k">&gt;=</span> <span class="pl-c1">2005</span>
<span class="pl-k">GROUP BY</span> year</pre></div>
<h3><a id="user-content-512-multiple-aggregations" class="anchor" aria-hidden="true" href="#512-multiple-aggregations"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>5.12 Multiple aggregations</h3>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> year,
<span class="pl-c1">SUM</span>(snow_depth) <span class="pl-k">as</span> total_snow,
<span class="pl-c1">SUM</span>(precipitation) <span class="pl-k">as</span> total_precipitation,
<span class="pl-c1">MAX</span>(precipitation) <span class="pl-k">as</span> max_precipitation

<span class="pl-k">FROM</span> station_data
<span class="pl-k">WHERE</span> year <span class="pl-k">&gt;=</span> <span class="pl-c1">2005</span>
<span class="pl-k">GROUP BY</span> year</pre></div>
<h3><a id="user-content-exercises" class="anchor" aria-hidden="true" href="#exercises"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>EXERCISES</h3>
<p>Flip to slides</p>
<h3><a id="user-content-513-using-having" class="anchor" aria-hidden="true" href="#513-using-having"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>5.13 Using HAVING</h3>
<p>You cannot use WHERE on aggregations. This will result in an error.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> year,
<span class="pl-c1">SUM</span>(precipitation) <span class="pl-k">as</span> total_precipitation
<span class="pl-k">FROM</span> station_data
<span class="pl-k">WHERE</span> total_precipitation <span class="pl-k">&gt;</span> <span class="pl-c1">30</span>
<span class="pl-k">GROUP BY</span> year</pre></div>
<p>You can however, use HAVING.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> year,
<span class="pl-c1">SUM</span>(precipitation) <span class="pl-k">as</span> total_precipitation
<span class="pl-k">FROM</span> station_data
<span class="pl-k">GROUP BY</span> year
<span class="pl-k">HAVING</span> total_precipitation <span class="pl-k">&gt;</span> <span class="pl-c1">30</span></pre></div>
<p>Note that some platforms like Oracle do not support aliasing in GROUP BY and HAVING.</p>
<p>Therefore you have to rewrite the entire expression each time</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> year,
<span class="pl-c1">SUM</span>(precipitation) <span class="pl-k">as</span> total_precipitation
<span class="pl-k">FROM</span> station_data
<span class="pl-k">GROUP BY</span> year
<span class="pl-k">HAVING</span> <span class="pl-c1">SUM</span>(precipitation) <span class="pl-k">&gt;</span> <span class="pl-c1">30</span></pre></div>
<h3><a id="user-content-514-getting-distinct-values" class="anchor" aria-hidden="true" href="#514-getting-distinct-values"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>5.14 Getting Distinct values</h3>
<p>You can get DISTINCT values for one or more columns</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT DISTINCT</span> station_number <span class="pl-k">FROM</span> station_data</pre></div>
<p>You can also get distinct combinations of values for multiple columns</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT DISTINCT</span> station_number, year <span class="pl-k">FROM</span> station_data</pre></div>
<h1><a id="user-content-section-vi---case-statements" class="anchor" aria-hidden="true" href="#section-vi---case-statements"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>Section VI - CASE Statements</h1>
<h3><a id="user-content-61-categorizing-wind-speed" class="anchor" aria-hidden="true" href="#61-categorizing-wind-speed"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>6.1 Categorizing Wind Speed</h3>
<p>You can use a <code>CASE</code> statement to turn a column value into another value based on conditions. For instance, we can turn different <code>wind_speed</code> ranges into <code>HIGH</code>, <code>MODERATE</code>, and <code>LOW</code> categories.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> report_code, year, month, day, wind_speed,

CASE
   WHEN wind_speed <span class="pl-k">&gt;=</span> <span class="pl-c1">40</span> THEN <span class="pl-s"><span class="pl-pds">'</span>HIGH<span class="pl-pds">'</span></span>
   WHEN wind_speed <span class="pl-k">&gt;=</span> <span class="pl-c1">30</span> <span class="pl-k">AND</span> wind_speed <span class="pl-k">&lt;</span> <span class="pl-c1">40</span> THEN <span class="pl-s"><span class="pl-pds">'</span>MODERATE<span class="pl-pds">'</span></span>
   ELSE <span class="pl-s"><span class="pl-pds">'</span>LOW<span class="pl-pds">'</span></span> END
<span class="pl-k">AS</span> wind_severity

<span class="pl-k">FROM</span> station_data</pre></div>
<h3><a id="user-content-62-more-efficient-way-to-categorize-wind-speed" class="anchor" aria-hidden="true" href="#62-more-efficient-way-to-categorize-wind-speed"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>6.2 More Efficient Way To Categorize Wind Speed</h3>
<p>We can actually omit <code>AND wind_speed &lt; 40</code> from the previous example because each <code>WHEN</code>/<code>THEN</code> is evaluated from top-to-bottom. The first one it finds to be true is the one it will go with, and stop evaluating subsequent conditions.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> report_code, year, month, day, wind_speed,

CASE
   WHEN wind_speed <span class="pl-k">&gt;=</span> <span class="pl-c1">40</span> THEN <span class="pl-s"><span class="pl-pds">'</span>HIGH<span class="pl-pds">'</span></span>
   WHEN wind_speed <span class="pl-k">&gt;=</span> <span class="pl-c1">30</span> THEN <span class="pl-s"><span class="pl-pds">'</span>MODERATE<span class="pl-pds">'</span></span>
   ELSE <span class="pl-s"><span class="pl-pds">'</span>LOW<span class="pl-pds">'</span></span>
END <span class="pl-k">as</span> wind_severity

<span class="pl-k">FROM</span> station_data</pre></div>
<h3><a id="user-content-63-using-case-with-group-by" class="anchor" aria-hidden="true" href="#63-using-case-with-group-by"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>6.3 Using CASE with GROUP BY</h3>
<p>We can use <code>GROUP BY</code> in conjunction with a <code>CASE</code> statement to slice data in more ways, such as getting the record count by <code>wind_severity</code>.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span>

CASE
    WHEN wind_speed <span class="pl-k">&gt;=</span> <span class="pl-c1">40</span> THEN <span class="pl-s"><span class="pl-pds">'</span>HIGH<span class="pl-pds">'</span></span>
    WHEN wind_speed <span class="pl-k">&gt;=</span> <span class="pl-c1">30</span> THEN <span class="pl-s"><span class="pl-pds">'</span>MODERATE<span class="pl-pds">'</span></span>
    ELSE <span class="pl-s"><span class="pl-pds">'</span>LOW<span class="pl-pds">'</span></span>
END <span class="pl-k">AS</span> wind_severity,

<span class="pl-c1">COUNT</span>(<span class="pl-k">*</span>) <span class="pl-k">AS</span> record_count

<span class="pl-k">FROM</span> STATION_DATA

<span class="pl-k">GROUP BY</span> wind_severity</pre></div>
<h3><a id="user-content-64-zeronull-case-trick" class="anchor" aria-hidden="true" href="#64-zeronull-case-trick"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>6.4 "Zero/Null" Case Trick</h3>
<p>There is really no way to create multiple aggregations with different conditions unless you know a trick with the <code>CASE</code> statement. If you want to find two total precipitation, with and without tornado precipitations, for each year and month, you have to do separate queries.</p>
<p><strong>Tornado Precipitation</strong></p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> year, month,
<span class="pl-c1">SUM</span>(precipitation) <span class="pl-k">as</span> tornado_precipitation
<span class="pl-k">FROM</span> station_data
<span class="pl-k">WHERE</span> tornado <span class="pl-k">=</span> <span class="pl-c1">1</span>
<span class="pl-k">AND</span> year <span class="pl-k">&gt;=</span> <span class="pl-c1">1990</span>
<span class="pl-k">GROUP BY</span> year, month</pre></div>
<p><strong>Non-Tornado Precipitation</strong></p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> year, month,
<span class="pl-c1">SUM</span>(precipitation) <span class="pl-k">as</span> non_tornado_precipitation
<span class="pl-k">FROM</span> station_data
<span class="pl-k">WHERE</span> tornado <span class="pl-k">=</span> <span class="pl-c1">0</span>
<span class="pl-k">AND</span> year <span class="pl-k">&gt;=</span> <span class="pl-c1">1990</span>
<span class="pl-k">GROUP BY</span> year, month</pre></div>
<p>But you can use a single query using a <code>CASE</code> statement that sets a value to 0 if the condition is not met. That way it will not impact the sum.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> year, month,
<span class="pl-c1">SUM</span>(CASE WHEN tornado <span class="pl-k">=</span> <span class="pl-c1">1</span> THEN precipitation ELSE <span class="pl-c1">0</span> END) <span class="pl-k">as</span> tornado_precipitation,
<span class="pl-c1">SUM</span>(CASE WHEN tornado <span class="pl-k">=</span> <span class="pl-c1">0</span> THEN precipitation ELSE <span class="pl-c1">0</span> END) <span class="pl-k">as</span> non_tornado_precipitation

<span class="pl-k">FROM</span> station_data
<span class="pl-k">WHERE</span> year <span class="pl-k">&gt;=</span> <span class="pl-c1">1990</span>

<span class="pl-k">GROUP BY</span> year, month</pre></div>
<p>Many folks who are not aware of the zero/null case trick will resort to derived tables (not covered in this class but covered in <em>Advanced SQL for Data Analysis</em>), which adds an unnecessary amount of effort and mess.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> <span class="pl-c1">t</span>.<span class="pl-c1">year</span>,
<span class="pl-c1">t</span>.<span class="pl-c1">month</span>,
<span class="pl-c1">t</span>.<span class="pl-c1">tornado_precipitation</span>,
<span class="pl-c1">non_t</span>.<span class="pl-c1">non_tornado_precipitation</span>

<span class="pl-k">FROM</span> (
    <span class="pl-k">SELECT</span> year, month,
    <span class="pl-c1">SUM</span>(precipitation) <span class="pl-k">as</span> tornado_precipitation
    <span class="pl-k">FROM</span> station_data
    <span class="pl-k">WHERE</span> tornado <span class="pl-k">=</span> <span class="pl-c1">1</span>
    <span class="pl-k">AND</span> year <span class="pl-k">&gt;=</span> <span class="pl-c1">1990</span>
    <span class="pl-k">GROUP BY</span> year, month
) t

<span class="pl-k">INNER JOIN</span>

(
    <span class="pl-k">SELECT</span> year, month,
    <span class="pl-c1">SUM</span>(precipitation) <span class="pl-k">as</span> non_tornado_precipitation
    <span class="pl-k">FROM</span> station_data
    <span class="pl-k">WHERE</span> tornado <span class="pl-k">=</span> <span class="pl-c1">0</span>
    <span class="pl-k">AND</span> year <span class="pl-k">&gt;=</span> <span class="pl-c1">1990</span>
    <span class="pl-k">GROUP BY</span> year, month
) non_t</pre></div>
<h3><a id="user-content-65-using-null-in-a-case-to-conditionalize-minmax" class="anchor" aria-hidden="true" href="#65-using-null-in-a-case-to-conditionalize-minmax"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>6.5 Using Null in a CASE to conditionalize MIN/MAX</h3>
<p>Since <code>NULL</code> is ignored in SUM, MIN, MAX, and other aggregate functions, you can use it in a <code>CASE</code> statement to conditionally control whether or not a value should be included in that aggregation.</p>
<p>For instance, we can split up max precipitation when a tornado was present vs not present.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> year,
<span class="pl-c1">MAX</span>(CASE WHEN tornado <span class="pl-k">=</span> <span class="pl-c1">0</span> THEN precipitation ELSE <span class="pl-k">NULL</span> END) <span class="pl-k">as</span> max_non_tornado_precipitation,
<span class="pl-c1">MAX</span>(CASE WHEN tornado <span class="pl-k">=</span> <span class="pl-c1">1</span> THEN precipitation ELSE <span class="pl-k">NULL</span> END) <span class="pl-k">as</span> max_tornado_precipitation
<span class="pl-k">FROM</span> station_data
<span class="pl-k">WHERE</span> year <span class="pl-k">&gt;=</span> <span class="pl-c1">1990</span>
<span class="pl-k">GROUP BY</span> year</pre></div>
<p><em>Switch to slides for exercise</em></p>
<h3><a id="user-content-exercise-61" class="anchor" aria-hidden="true" href="#exercise-61"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>Exercise 6.1</h3>
<p>SELECT  the report_code, year, quarter, and temperature, where a “quarter” is “Q1”, “Q2”, “Q3”, or “Q4” reflecting months 1-3, 4-6, 7-9, and 10-12 respectively.</p>
<p><strong>ANSWER:</strong></p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span>

report_code,
year,

CASE
    WHEN month BETWEEN <span class="pl-c1">1</span> <span class="pl-k">and</span> <span class="pl-c1">3</span> THEN <span class="pl-s"><span class="pl-pds">'</span>Q1<span class="pl-pds">'</span></span>
    WHEN month BETWEEN <span class="pl-c1">4</span> <span class="pl-k">and</span> <span class="pl-c1">6</span> THEN <span class="pl-s"><span class="pl-pds">'</span>Q2<span class="pl-pds">'</span></span>
    WHEN month BETWEEN <span class="pl-c1">7</span> <span class="pl-k">and</span> <span class="pl-c1">9</span> THEN <span class="pl-s"><span class="pl-pds">'</span>Q3<span class="pl-pds">'</span></span>
    WHEN month BETWEEN <span class="pl-c1">10</span> <span class="pl-k">and</span> <span class="pl-c1">12</span> THEN <span class="pl-s"><span class="pl-pds">'</span>Q4<span class="pl-pds">'</span></span>
END <span class="pl-k">as</span> quarter,

temperature

<span class="pl-k">FROM</span> STATION_DATA</pre></div>
<h3><a id="user-content-exercise-62" class="anchor" aria-hidden="true" href="#exercise-62"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>Exercise 6.2</h3>
<p>Get the average temperature by quarter and month, where a “quarter” is “Q1”, “Q2”, “Q3”, or “Q4” reflecting months 1-3, 4-6, 7-9, and 10-12 respectively.</p>
<p><strong>ANSWER</strong></p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span>
year,

CASE
    WHEN month BETWEEN <span class="pl-c1">1</span> <span class="pl-k">and</span> <span class="pl-c1">3</span> THEN <span class="pl-s"><span class="pl-pds">'</span>Q1<span class="pl-pds">'</span></span>
    WHEN month BETWEEN <span class="pl-c1">4</span> <span class="pl-k">and</span> <span class="pl-c1">6</span> THEN <span class="pl-s"><span class="pl-pds">'</span>Q2<span class="pl-pds">'</span></span>
    WHEN month BETWEEN <span class="pl-c1">7</span> <span class="pl-k">and</span> <span class="pl-c1">9</span> THEN <span class="pl-s"><span class="pl-pds">'</span>Q3<span class="pl-pds">'</span></span>
    WHEN month BETWEEN <span class="pl-c1">10</span> <span class="pl-k">and</span> <span class="pl-c1">12</span> THEN <span class="pl-s"><span class="pl-pds">'</span>Q4<span class="pl-pds">'</span></span>
END <span class="pl-k">as</span> quarter,

<span class="pl-c1">AVG</span>(temperature) <span class="pl-k">as</span> avg_temp

<span class="pl-k">FROM</span> STATION_DATA
<span class="pl-k">GROUP BY</span> <span class="pl-c1">1</span>,<span class="pl-c1">2</span></pre></div>
<h1><a id="user-content-section-vii---join" class="anchor" aria-hidden="true" href="#section-vii---join"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>Section VII - JOIN</h1>
<h3><a id="user-content-71a-inner-join" class="anchor" aria-hidden="true" href="#71a-inner-join"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>7.1A INNER JOIN</h3>
<p>(Refer to slides Section VII)</p>
<p>View customer address information with each order by joining tables <code>CUSTOMER</code> and <code>CUSTOMER_ORDER</code>.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> ORDER_ID,
<span class="pl-c1">CUSTOMER</span>.<span class="pl-c1">CUSTOMER_ID</span>,
ORDER_DATE,
SHIP_DATE,
NAME,
STREET_ADDRESS,
CITY,
STATE,
ZIP,
PRODUCT_ID,
ORDER_QTY

<span class="pl-k">FROM</span> CUSTOMER <span class="pl-k">INNER JOIN</span> CUSTOMER_ORDER
<span class="pl-k">ON</span> <span class="pl-c1">CUSTOMER</span>.<span class="pl-c1">CUSTOMER_ID</span> <span class="pl-k">=</span> <span class="pl-c1">CUSTOMER_ORDER</span>.<span class="pl-c1">CUSTOMER_ID</span></pre></div>
<p>Joins allow us to keep stored data normalized and simple, but we can get more descriptive views of our data by using joins.</p>
<p>Notice how two customers are omitted since they don't have any orders (refer to slides).</p>
<h3><a id="user-content-72b-a-bad-approach" class="anchor" aria-hidden="true" href="#72b-a-bad-approach"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>7.2B A BAD APPROACH</h3>
<p>You may come across a style of joining where commas are used to select the needed tables, and a <code>WHERE</code> defines the join condition as shown below:</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> ORDER_ID,
<span class="pl-c1">CUSTOMER</span>.<span class="pl-c1">CUSTOMER_ID</span>,
ORDER_DATE,
SHIP_DATE,
NAME,
STREET_ADDRESS,
CITY,
STATE,
ZIP,
PRODUCT_ID,
ORDER_QTY

<span class="pl-k">FROM</span> CUSTOMER, CUSTOMER_ORDER
<span class="pl-k">WHERE</span> <span class="pl-c1">CUSTOMER</span>.<span class="pl-c1">CUSTOMER_ID</span> <span class="pl-k">=</span> <span class="pl-c1">CUSTOMER_ORDER</span>.<span class="pl-c1">CUSTOMER_ID</span></pre></div>
<p>Do not use this approach no matter how much your colleagues use it (and educate them not to use it either). It is extremely inefficient as it will generate a cartesian product across both tables (every possible combination of records between both), and then filter it based on the WHERE. It does not work with <code>LEFT JOIN</code> either, which we will look at shortly.</p>
<p>Using the <code>INNER JOIN</code> with an <code>ON</code> condition avoids the cartesian product and is more efficient. Therefore, always use that approach.</p>
<h3><a id="user-content-72-left-outer-join" class="anchor" aria-hidden="true" href="#72-left-outer-join"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>7.2 LEFT OUTER JOIN</h3>
<p>To include all customers, regardless of whether they have orders, you can use a left outer join via <code>LEFT JOIN</code> (refer to slides).</p>
<p>If any customers do not have any orders, they will get one record where the <code>CUSTOMER_ORDER</code> fields will be null.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> <span class="pl-c1">CUSTOMER</span>.<span class="pl-c1">CUSTOMER_ID</span>,
NAME,
STREET_ADDRESS,
CITY,
STATE,
ZIP,
ORDER_DATE,
SHIP_DATE,
ORDER_ID,
PRODUCT_ID,
ORDER_QTY

<span class="pl-k">FROM</span> CUSTOMER <span class="pl-k">LEFT JOIN</span> CUSTOMER_ORDER
<span class="pl-k">ON</span> <span class="pl-c1">CUSTOMER</span>.<span class="pl-c1">CUSTOMER_ID</span> <span class="pl-k">=</span> <span class="pl-c1">CUSTOMER_ORDER</span>.<span class="pl-c1">CUSTOMER_ID</span></pre></div>
<h2><a id="user-content-73-finding-customers-with-no-orders" class="anchor" aria-hidden="true" href="#73-finding-customers-with-no-orders"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>7.3 Finding Customers with No Orders</h2>
<p>With a left outer join, you can filter for NULL values on the <code>CUSTOMER_ORDER</code> table to find customers that have no orders.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> <span class="pl-c1">CUSTOMER</span>.<span class="pl-c1">CUSTOMER_ID</span>,
NAME <span class="pl-k">AS</span> CUSTOMER_NAME

<span class="pl-k">FROM</span> CUSTOMER <span class="pl-k">LEFT JOIN</span> CUSTOMER_ORDER
<span class="pl-k">ON</span> <span class="pl-c1">CUSTOMER</span>.<span class="pl-c1">CUSTOMER_ID</span> <span class="pl-k">=</span> <span class="pl-c1">CUSTOMER_ORDER</span>.<span class="pl-c1">CUSTOMER_ID</span>

<span class="pl-k">WHERE</span> ORDER_ID IS <span class="pl-k">NULL</span></pre></div>
<p>You can use a left outer join to find child records with no parent, or parent records with no children (e.g. a <code>CUSTOMER_ORDER</code> with no <code>CUSTOMER</code>, or a <code>CUSTOMER</code> with no <code>CUSTOMER_ORDER</code>s).</p>
<h2><a id="user-content-74-joining-multiple-tables" class="anchor" aria-hidden="true" href="#74-joining-multiple-tables"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>7.4 Joining Multiple Tables</h2>
<p>Bring in <code>PRODUCT</code> to supply product information for each <code>CUSTOMER_ORDER</code>, on top of <code>CUSTOMER</code> information.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> ORDER_ID,
<span class="pl-c1">CUSTOMER</span>.<span class="pl-c1">CUSTOMER_ID</span>,
NAME <span class="pl-k">AS</span> CUSTOMER_NAME,
STREET_ADDRESS,
CITY,
STATE,
ZIP,
ORDER_DATE,
<span class="pl-c1">PRODUCT</span>.<span class="pl-c1">PRODUCT_ID</span>,
DESCRIPTION,
ORDER_QTY

<span class="pl-k">FROM</span> CUSTOMER <span class="pl-k">INNER JOIN</span> CUSTOMER_ORDER
<span class="pl-k">ON</span> <span class="pl-c1">CUSTOMER</span>.<span class="pl-c1">CUSTOMER_ID</span> <span class="pl-k">=</span> <span class="pl-c1">CUSTOMER_ORDER</span>.<span class="pl-c1">CUSTOMER_ID</span>

<span class="pl-k">INNER JOIN</span> PRODUCT
<span class="pl-k">ON</span> <span class="pl-c1">CUSTOMER_ORDER</span>.<span class="pl-c1">PRODUCT_ID</span> <span class="pl-k">=</span> <span class="pl-c1">PRODUCT</span>.<span class="pl-c1">PRODUCT_ID</span></pre></div>
<h2><a id="user-content-77-using-expressions-with-joins" class="anchor" aria-hidden="true" href="#77-using-expressions-with-joins"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>7.7 Using Expressions with JOINs</h2>
<p>You can use expressions combining any fields on any of the joined tables. For instance, we can now get the total revenue for each customer.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> ORDER_ID,
<span class="pl-c1">CUSTOMER</span>.<span class="pl-c1">CUSTOMER_ID</span>,
NAME <span class="pl-k">AS</span> CUSTOMER_NAME,
STREET_ADDRESS,
CITY,
STATE,
ZIP,
ORDER_DATE,
<span class="pl-c1">PRODUCT</span>.<span class="pl-c1">PRODUCT_ID</span>,
DESCRIPTION,
ORDER_QTY,
ORDER_QTY <span class="pl-k">*</span> PRICE <span class="pl-k">as</span> REVENUE

<span class="pl-k">FROM</span> CUSTOMER <span class="pl-k">INNER JOIN</span> CUSTOMER_ORDER
<span class="pl-k">ON</span> <span class="pl-c1">CUSTOMER</span>.<span class="pl-c1">CUSTOMER_ID</span> <span class="pl-k">=</span> <span class="pl-c1">CUSTOMER_ORDER</span>.<span class="pl-c1">CUSTOMER_ID</span>

<span class="pl-k">INNER JOIN</span> PRODUCT
<span class="pl-k">ON</span> <span class="pl-c1">CUSTOMER_ORDER</span>.<span class="pl-c1">PRODUCT_ID</span> <span class="pl-k">=</span> <span class="pl-c1">PRODUCT</span>.<span class="pl-c1">PRODUCT_ID</span></pre></div>
<h2><a id="user-content-76-using-group-by-with-joins" class="anchor" aria-hidden="true" href="#76-using-group-by-with-joins"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>7.6 Using GROUP BY with JOINs</h2>
<p>You can use <code>GROUP BY</code> with a join. For instance, you can find the total revenue for each customer by leveraging all three joined tables, and aggregating the <code>REVENUE</code> expression we created earlier.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span>
<span class="pl-c1">CUSTOMER</span>.<span class="pl-c1">CUSTOMER_ID</span>,
NAME <span class="pl-k">AS</span> CUSTOMER_NAME,
<span class="pl-c1">sum</span>(ORDER_QTY <span class="pl-k">*</span> PRICE) <span class="pl-k">as</span> TOTAL_REVENUE

<span class="pl-k">FROM</span> CUSTOMER <span class="pl-k">INNER JOIN</span> CUSTOMER_ORDER
<span class="pl-k">ON</span> <span class="pl-c1">CUSTOMER</span>.<span class="pl-c1">CUSTOMER_ID</span> <span class="pl-k">=</span> <span class="pl-c1">CUSTOMER_ORDER</span>.<span class="pl-c1">CUSTOMER_ID</span>

<span class="pl-k">INNER JOIN</span> PRODUCT
<span class="pl-k">ON</span> <span class="pl-c1">CUSTOMER_ORDER</span>.<span class="pl-c1">PRODUCT_ID</span> <span class="pl-k">=</span> <span class="pl-c1">PRODUCT</span>.<span class="pl-c1">PRODUCT_ID</span>

<span class="pl-k">GROUP BY</span> <span class="pl-c1">1</span>,<span class="pl-c1">2</span></pre></div>
<p>To see all customers even if they had no orders, use a <code>LEFT JOIN</code></p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span>
<span class="pl-c1">CUSTOMER</span>.<span class="pl-c1">CUSTOMER_ID</span>,
NAME <span class="pl-k">AS</span> CUSTOMER_NAME,
<span class="pl-c1">sum</span>(ORDER_QTY <span class="pl-k">*</span> PRICE) <span class="pl-k">as</span> TOTAL_REVENUE

<span class="pl-k">FROM</span> CUSTOMER <span class="pl-k">LEFT JOIN</span> CUSTOMER_ORDER
<span class="pl-k">ON</span> <span class="pl-c1">CUSTOMER</span>.<span class="pl-c1">CUSTOMER_ID</span> <span class="pl-k">=</span> <span class="pl-c1">CUSTOMER_ORDER</span>.<span class="pl-c1">CUSTOMER_ID</span>

<span class="pl-k">LEFT JOIN</span> PRODUCT
<span class="pl-k">ON</span> <span class="pl-c1">CUSTOMER_ORDER</span>.<span class="pl-c1">PRODUCT_ID</span> <span class="pl-k">=</span> <span class="pl-c1">PRODUCT</span>.<span class="pl-c1">PRODUCT_ID</span>

<span class="pl-k">GROUP BY</span> <span class="pl-c1">1</span>,<span class="pl-c1">2</span></pre></div>
<p>You can also use a <code>coalesce()</code> function to turn null sums into zeros.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span>
<span class="pl-c1">CUSTOMER</span>.<span class="pl-c1">CUSTOMER_ID</span>,
NAME <span class="pl-k">AS</span> CUSTOMER_NAME,
coalesce(<span class="pl-c1">sum</span>(ORDER_QTY <span class="pl-k">*</span> PRICE), <span class="pl-c1">0</span>) <span class="pl-k">as</span> TOTAL_REVENUE

<span class="pl-k">FROM</span> CUSTOMER <span class="pl-k">LEFT JOIN</span> CUSTOMER_ORDER
<span class="pl-k">ON</span> <span class="pl-c1">CUSTOMER</span>.<span class="pl-c1">CUSTOMER_ID</span> <span class="pl-k">=</span> <span class="pl-c1">CUSTOMER_ORDER</span>.<span class="pl-c1">CUSTOMER_ID</span>

<span class="pl-k">LEFT JOIN</span> PRODUCT
<span class="pl-k">ON</span> <span class="pl-c1">CUSTOMER_ORDER</span>.<span class="pl-c1">PRODUCT_ID</span> <span class="pl-k">=</span> <span class="pl-c1">PRODUCT</span>.<span class="pl-c1">PRODUCT_ID</span>

<span class="pl-k">GROUP BY</span> <span class="pl-c1">1</span>,<span class="pl-c1">2</span></pre></div>
<h1><a id="user-content-section-viii---database-design" class="anchor" aria-hidden="true" href="#section-viii---database-design"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>Section VIII - Database Design</h1>
<p>Refer to slides for database design concepts</p>
<p>To view source code for SQL Injection Demo, here is the GitHub page:
<a href="https://github.com/thomasnield/sql-injection-demo">https://github.com/thomasnield/sql-injection-demo</a></p>
<p>To read about normalized forms (which we do not cover in favor of a more intuitive approach), you can read this article:</p>
<p><a href="http://www.dummies.com/programming/sql/sql-first-second-and-third-normal-forms/" rel="nofollow">http://www.dummies.com/programming/sql/sql-first-second-and-third-normal-forms/</a></p>
<h2><a id="user-content-71---creating-a-table" class="anchor" aria-hidden="true" href="#71---creating-a-table"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>7.1 - Creating a Table</h2>
<p>In SQLiteStudio, navigate to <em>Database</em> -&gt; <em>Add a Database</em> and click the green plus icon to create a new database. Choose a location and name it <code>surgetech_conference.db</code>.</p>
<p>Create the <code>COMPANY</code> table. To create a new table, use the SQLiteStudio wizard by right-clicking the <code>surgetech_conference</code> database and selecting <code>Create a table</code>. You can also just execute the following SQL.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">CREATE</span> <span class="pl-k">TABLE</span> <span class="pl-en">COMPANY</span> (
  COMPANY_ID <span class="pl-k">INTEGER</span> <span class="pl-k">PRIMARY KEY</span> AUTOINCREMENT,
  NAME <span class="pl-k">VARCHAR</span>(<span class="pl-c1">30</span>) <span class="pl-k">NOT NULL</span>,
  DESCRIPTION <span class="pl-k">VARCHAR</span>(<span class="pl-c1">60</span>),
  PRIMARY_CONTACT_ATTENDEE_ID <span class="pl-k">INTEGER</span> <span class="pl-k">NOT NULL</span>,
  <span class="pl-k">FOREIGN KEY</span> (PRIMARY_CONTACT_ATTENDEE_ID) <span class="pl-k">REFERENCES</span> ATTENDEE(ATTENDEE_ID)
);</pre></div>
<p>After each field declaration, we create "rules" for that field. For example, <code>COMPANY_ID</code> must be an <code>INTEGER</code>, it is a <code>PRIMARY KEY</code>, and it will <code>AUTOINCREMENT</code> to automatically generate a consecutive integer ID for each new record. The <code>NAME</code> field holds text because it is <code>VARCHAR</code> (a variable number of characters), and it is limited to 30 characters and cannot be <code>NULL</code>.</p>
<p>Lastly, we declare any <code>FOREIGN KEY</code> constraints, specifying which field is a <code>FOREIGN KEY</code> and what <code>PRIMARY KEY</code> it references. In this example, <code>PRIMARY_CONTACT_ATTENDEE_ID</code> "references" the <code>ATTENDEE_ID</code> in the <code>ATTENDEE</code> table, and it can only be those values.</p>
<h2><a id="user-content-72---creating-the-other-tables" class="anchor" aria-hidden="true" href="#72---creating-the-other-tables"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>7.2 - Creating the other tables</h2>
<p>Create the other tables using the SQLiteStudio <em>New table</em> wizard, or just executing the following SQL code.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">CREATE</span> <span class="pl-k">TABLE</span> <span class="pl-en">ROOM</span> (
  ROOM_ID <span class="pl-k">INTEGER</span> <span class="pl-k">PRIMARY KEY</span> AUTOINCREMENT,
  FLOOR_NUMBER <span class="pl-k">INTEGER</span> <span class="pl-k">NOT NULL</span>,
  SEAT_CAPACITY <span class="pl-k">INTEGER</span> <span class="pl-k">NOT NULL</span>
);

<span class="pl-k">CREATE</span> <span class="pl-k">TABLE</span> <span class="pl-en">PRESENTATION</span> (
  PRESENTATION_ID <span class="pl-k">INTEGER</span> <span class="pl-k">PRIMARY KEY</span> AUTOINCREMENT,
  BOOKED_COMPANY_ID <span class="pl-k">INTEGER</span> <span class="pl-k">NOT NULL</span>,
  BOOKED_ROOM_ID <span class="pl-k">INTEGER</span> <span class="pl-k">NOT NULL</span>,
  START_TIME <span class="pl-k">TIME</span>,
  END_TIME <span class="pl-k">TIME</span>,
  <span class="pl-k">FOREIGN KEY</span> (BOOKED_COMPANY_ID) <span class="pl-k">REFERENCES</span> COMPANY(COMPANY_ID)
  <span class="pl-k">FOREIGN KEY</span> (BOOKED_ROOM_ID) <span class="pl-k">REFERENCES</span> ROOM(ROOM_ID)
);

<span class="pl-k">CREATE</span> <span class="pl-k">TABLE</span> <span class="pl-en">ATTENDEE</span> (
   ATTENDEE_ID <span class="pl-k">INTEGER</span> <span class="pl-k">PRIMARY KEY</span> AUTOINCREMENT,
   FIRST_NAME <span class="pl-k">VARCHAR</span> (<span class="pl-c1">30</span>) <span class="pl-k">NOT NULL</span>,
   LAST_NAME <span class="pl-k">VARCHAR</span> (<span class="pl-c1">30</span>) <span class="pl-k">NOT NULL</span>,
   PHONE <span class="pl-k">INTEGER</span>,
   EMAIL <span class="pl-k">VARCHAR</span> (<span class="pl-c1">30</span>),
   VIP <span class="pl-k">BOOLEAN</span> DEFAULT (<span class="pl-c1">0</span>)
);

<span class="pl-k">CREATE</span> <span class="pl-k">TABLE</span> <span class="pl-en">PRESENTATION_ATTENDANCE</span> (
  TICKET_ID <span class="pl-k">INTEGER</span> <span class="pl-k">PRIMARY KEY</span> AUTOINCREMENT,
  PRESENTATION_ID <span class="pl-k">INTEGER</span>,
  ATTENDEE_ID <span class="pl-k">INTEGER</span>,
  <span class="pl-k">FOREIGN KEY</span> (PRESENTATION_ID) <span class="pl-k">REFERENCES</span> PRESENTATION(PRESENTATION_ID)
  <span class="pl-k">FOREIGN KEY</span> (ATTENDEE_ID) <span class="pl-k">REFERENCES</span> ATTENDEE(ATTENDEE_ID)
);</pre></div>
<h2><a id="user-content-creating-views" class="anchor" aria-hidden="true" href="#creating-views"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>Creating Views</h2>
<p>It is not uncommon to save <code>SELECT</code> queries that are used frequently into a database. These are known as <strong>Views</strong> and act very similarly to tables. You can essentially save a <code>SELECT</code> query and work with it just like a table.</p>
<p>For instance, say we wanted to save this SQL query that includes <code>ROOM</code> and <code>COMPANY</code> info with each <code>PRESENTATION</code> record.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> <span class="pl-c1">COMPANY</span>.<span class="pl-c1">NAME</span> <span class="pl-k">as</span> BOOKED_COMPANY,
<span class="pl-c1">ROOM</span>.<span class="pl-c1">ROOM_ID</span> <span class="pl-k">as</span> ROOM_NUMBER,
<span class="pl-c1">ROOM</span>.<span class="pl-c1">FLOOR_NUMBER</span> <span class="pl-k">as</span> FLOOR,
<span class="pl-c1">ROOM</span>.<span class="pl-c1">SEAT_CAPACITY</span> <span class="pl-k">as</span> SEATS,
START_TIME, END_TIME

<span class="pl-k">FROM</span> PRESENTATION

<span class="pl-k">INNER JOIN</span> COMPANY
<span class="pl-k">ON</span> <span class="pl-c1">PRESENTATION</span>.<span class="pl-c1">BOOKED_COMPANY_ID</span> <span class="pl-k">=</span> <span class="pl-c1">COMPANY</span>.<span class="pl-c1">COMPANY_ID</span>

<span class="pl-k">INNER JOIN</span> ROOM
<span class="pl-k">ON</span> <span class="pl-c1">PRESENTATION</span>.<span class="pl-c1">BOOKED_ROOM_ID</span> <span class="pl-k">=</span> <span class="pl-c1">ROOM</span>.<span class="pl-c1">ROOM_ID</span></pre></div>
<p>You can save this as a view by right-clicking <em>Views</em> in the database navigator, and then <em>Create a view</em>. You can then paste the SQL as the body and give the view a name, such as <code>PRESENTATION_VW</code> (where "VW" means "View").</p>
<p>You can also just execute the following SQL syntax: <code>CREATE [view name]  AS [a SELECT query]</code>. For this example, this is what it would look like.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">CREATE</span> <span class="pl-k">VIEW</span> <span class="pl-en">PRESENTATION_VW</span> <span class="pl-k">AS</span>

<span class="pl-k">SELECT</span> <span class="pl-c1">COMPANY</span>.<span class="pl-c1">NAME</span> <span class="pl-k">as</span> BOOKED_COMPANY,
<span class="pl-c1">ROOM</span>.<span class="pl-c1">ROOM_ID</span> <span class="pl-k">as</span> ROOM_NUMBER,
<span class="pl-c1">ROOM</span>.<span class="pl-c1">FLOOR_NUMBER</span> <span class="pl-k">as</span> FLOOR,
<span class="pl-c1">ROOM</span>.<span class="pl-c1">SEAT_CAPACITY</span> <span class="pl-k">as</span> SEATS,
START_TIME, END_TIME

<span class="pl-k">FROM</span> PRESENTATION

<span class="pl-k">INNER JOIN</span> COMPANY
<span class="pl-k">ON</span> <span class="pl-c1">PRESENTATION</span>.<span class="pl-c1">BOOKED_COMPANY_ID</span> <span class="pl-k">=</span> <span class="pl-c1">COMPANY</span>.<span class="pl-c1">COMPANY_ID</span>

<span class="pl-k">INNER JOIN</span> ROOM
<span class="pl-k">ON</span> <span class="pl-c1">PRESENTATION</span>.<span class="pl-c1">BOOKED_ROOM_ID</span> <span class="pl-k">=</span> <span class="pl-c1">ROOM</span>.<span class="pl-c1">ROOM_ID</span></pre></div>
<p>You will then see the <code>PRESENTATION_VW</code> in your database navigator, and you can query it just like a table.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> <span class="pl-k">*</span> <span class="pl-k">FROM</span> PRESENTATION_VW
<span class="pl-k">WHERE</span> SEATS <span class="pl-k">&gt;=</span> <span class="pl-c1">30</span></pre></div>
<p>Obviously, there is no data yet so you will not get any results. But there will be once you populate data into this database.</p>
<h1><a id="user-content-section-ix---writing-data" class="anchor" aria-hidden="true" href="#section-ix---writing-data"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>Section IX - Writing Data</h1>
<p>In this section, we will learn how to write, modify, and delete data in a database.</p>
<h2><a id="user-content-91-using-insert" class="anchor" aria-hidden="true" href="#91-using-insert"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>9.1 Using <code>INSERT</code></h2>
<p>To create a new record in a table, use the <code>INSERT</code> command and supply the values for the needed columns.</p>
<p>Put yourself into the <code>ATTENDEE</code> table.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">INSERT INTO</span> ATTENDEE (FIRST_NAME, LAST_NAME)
<span class="pl-k">VALUES</span> (<span class="pl-s"><span class="pl-pds">'</span>Thomas<span class="pl-pds">'</span></span>,<span class="pl-s"><span class="pl-pds">'</span>Nield<span class="pl-pds">'</span></span>)</pre></div>
<p>Notice above that we declare the table we are writing to, which is <code>ATTENDEE</code>. Then we declare the columns we are supplying values for <code>(FIRST_NAME, LAST_NAME)</code>, followed by the values for this new record <code>('Thomas','Nield')</code>.</p>
<p>Notice we did not have to supply a value for <code>ATTENDEE_ID</code> as we have set it in the previous section to generate its own value. <code>PHONE</code>, <code>EMAIL</code>, and <code>VIP</code> fields have default values or are nullable, and therefore optional.</p>
<h2><a id="user-content-92-multiple-insert-records" class="anchor" aria-hidden="true" href="#92-multiple-insert-records"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>9.2 Multiple <code>INSERT</code> records</h2>
<p>You can insert multiple rows in an <code>INSERT</code>. This will add three people to the <code>ATTENDEE</code> table.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">INSERT INTO</span> ATTENDEE (FIRST_NAME, LAST_NAME, PHONE, EMAIL, VIP)
<span class="pl-k">VALUES</span> (<span class="pl-s"><span class="pl-pds">'</span>Jon<span class="pl-pds">'</span></span>, <span class="pl-s"><span class="pl-pds">'</span>Skeeter<span class="pl-pds">'</span></span>, <span class="pl-c1">4802185842</span>,<span class="pl-s"><span class="pl-pds">'</span>john.skeeter@rex.net<span class="pl-pds">'</span></span>, <span class="pl-c1">1</span>),
  (<span class="pl-s"><span class="pl-pds">'</span>Sam<span class="pl-pds">'</span></span>,<span class="pl-s"><span class="pl-pds">'</span>Scala<span class="pl-pds">'</span></span>, <span class="pl-c1">2156783401</span>,<span class="pl-s"><span class="pl-pds">'</span>sam.scala@gmail.com<span class="pl-pds">'</span></span>, <span class="pl-c1">0</span>),
  (<span class="pl-s"><span class="pl-pds">'</span>Brittany<span class="pl-pds">'</span></span>,<span class="pl-s"><span class="pl-pds">'</span>Fisher<span class="pl-pds">'</span></span>, <span class="pl-c1">5932857296</span>,<span class="pl-s"><span class="pl-pds">'</span>brittany.fisher@outlook.com<span class="pl-pds">'</span></span>, <span class="pl-c1">0</span>)</pre></div>
<h2><a id="user-content-93-testing-the-foreign-keys" class="anchor" aria-hidden="true" href="#93-testing-the-foreign-keys"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>9.3 Testing the foreign keys</h2>
<p>Let's test our design and make sure our primary/foreign keys are working.</p>
<p>Try to <code>INSERT</code> a <code>COMPANY</code> with a <code>PRIMARY_CONTACT_ATTENDEE_ID</code> that does not exist in the <code>ATTENDEE</code> table.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">INSERT INTO</span> COMPANY (NAME, DESCRIPTION, PRIMARY_CONTACT_ATTENDEE_ID)
<span class="pl-k">VALUES</span> (<span class="pl-s"><span class="pl-pds">'</span>RexApp Solutions<span class="pl-pds">'</span></span>,<span class="pl-s"><span class="pl-pds">'</span>A mobile app delivery service<span class="pl-pds">'</span></span>, <span class="pl-c1">5</span>)</pre></div>
<p>Currently, there is no <code>ATTENDEE</code> with an <code>ATTENDEE_ID</code> of 5, this should error out which is good. It means we kept bad data out.</p>
<p>If you use an <code>ATTENDEE_ID</code> value that does exist and supply it as a <code>PRIMARY_CONTACT_ATTENDEE_ID</code>, we should be good to go.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">INSERT INTO</span> COMPANY (NAME, DESCRIPTION, PRIMARY_CONTACT_ATTENDEE_ID)
<span class="pl-k">VALUES</span> (<span class="pl-s"><span class="pl-pds">'</span>RexApp Solutions<span class="pl-pds">'</span></span>, <span class="pl-s"><span class="pl-pds">'</span>A mobile app delivery service<span class="pl-pds">'</span></span>, <span class="pl-c1">3</span>)</pre></div>
<h3><a id="user-content-93-delete-records" class="anchor" aria-hidden="true" href="#93-delete-records"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>9.3 <code>DELETE</code> records</h3>
<p>The <code>DELETE</code> command is dangerously simple. To delete records from both the <code>COMPANY</code> and <code>ATTENDEE</code> tables, execute the following SQL commands.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">DELETE</span> <span class="pl-k">FROM</span> COMPANY;
<span class="pl-k">DELETE</span> <span class="pl-k">FROM</span> ATTENDEE;</pre></div>
<p>Note that the <code>COMPANY</code> table has a foreign key relationship with the <code>ATTENDEE</code> table. Therefore we will have to delete records from <code>COMPANY</code> first before it allows us to delete data from <code>ATTENDEE</code>. Otherwise we will get a "FOREIGN KEY constraint failed effort" due to the <code>COMPANY</code> record we just added which is tied to the <code>ATTENDEE</code> with the <code>ATTENDEE_ID</code> of 3.</p>
<p>You can also use a <code>WHERE</code> to only delete records that meet a conditional. To delete all <code>ATTENDEE</code> records with no <code>PHONE</code> or <code>EMAIL</code>, you can run this command.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">DELETE</span> <span class="pl-k">FROM</span> ATTENDEE
<span class="pl-k">WHERE</span> PHONE IS <span class="pl-k">NULL</span> <span class="pl-k">AND</span> EMAIL IS <span class="pl-k">NULL</span></pre></div>
<p>A good practice is to use a <code>SELECT *</code> in place of the <code>DELETE</code> first. That way you can get a preview of what records will be deleted with that <code>WHERE</code> condition.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> <span class="pl-k">*</span> <span class="pl-k">FROM</span> ATTENDEE
<span class="pl-k">WHERE</span> PHONE IS <span class="pl-k">NULL</span> <span class="pl-k">AND</span> EMAIL IS <span class="pl-k">NULL</span></pre></div>
<h3><a id="user-content-update-records" class="anchor" aria-hidden="true" href="#update-records"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a><code>UPDATE</code> records</h3>
<p>Say we wanted to change the phone number for the <code>ATTENDEE</code> with the <code>ATTENDEE_ID</code> value of 3, which is Sam Scala. We can do this with an <code>UPDATE</code> statement.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">UPDATE</span> ATTENDEE <span class="pl-k">SET</span> PHONE <span class="pl-k">=</span> <span class="pl-c1">4802735872</span>
<span class="pl-k">WHERE</span> ATTENDEE_ID <span class="pl-k">=</span> <span class="pl-c1">3</span></pre></div>
<p>Using a <code>WHERE</code> is important, otherwise it will update all records with the specified <code>SET</code> assignment. This can be handy if you wanted to say, make all <code>EMAIL</code> values uppercase.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">UPDATE</span> ATTENDEE <span class="pl-k">SET</span> EMAIL <span class="pl-k">=</span> <span class="pl-c1">UPPER</span>(EMAIL)</pre></div>
<h3><a id="user-content-94-dropping-tables" class="anchor" aria-hidden="true" href="#94-dropping-tables"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>9.4 Dropping Tables</h3>
<p>If you want to delete a table, it also is dangerously simple. Be very careful and sure before you delete any table, because it will remove it permanently.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">DROP</span> <span class="pl-k">TABLE</span> MY_UNWANTED_TABLE</pre></div>
<h3><a id="user-content-95-transactions" class="anchor" aria-hidden="true" href="#95-transactions"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>9.5 Transactions</h3>
<p>Transactions are helpful when you want a series of writes to succeed.</p>
<p>Below, we execute two successful write operations within a transaction.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">BEGIN</span> TRANSACTION;

<span class="pl-k">INSERT INTO</span> ROOM (FLOOR_NUMBER, SEAT_CAPACITY) <span class="pl-k">VALUES</span> (<span class="pl-c1">9</span>, <span class="pl-c1">80</span>);
<span class="pl-k">INSERT INTO</span> ROOM (FLOOR_NUMBER, SEAT_CAPACITY) <span class="pl-k">VALUES</span> (<span class="pl-c1">10</span>, <span class="pl-c1">110</span>);

END TRANSACTION;</pre></div>
<p>But if we ever encountered a failure with our write operations, we can call <code>ROLLBACK</code> instead of <code>END TRANSACTION</code> to go back to the database state when <code>BEGIN TRANSACTION</code> was called.</p>
<p>Below, we have a failed operation due to a broken <code>INSERT</code>.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">BEGIN</span> TRANSACTION;

<span class="pl-k">INSERT INTO</span> ROOM (FLOOR_NUMBER, SEAT_CAPACITY) <span class="pl-k">VALUES</span> (<span class="pl-c1">12</span>, <span class="pl-c1">210</span>);
<span class="pl-k">INSERT INTO</span> ROOM (FLOOR_NUMBER, SEAT_CAPACITY) <span class="pl-k">VALUES</span> (<span class="pl-c1">13</span>); <span class="pl-c"><span class="pl-c">--</span>failure</span></pre></div>
<p>So we can call <code>ROLLBACK</code> to "rewind" to the database state when <code>BEGIN TRANSACTION</code> was called.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">ROLLBACK</span>;</pre></div>
<h3><a id="user-content-96-creating-indexes" class="anchor" aria-hidden="true" href="#96-creating-indexes"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>9.6 Creating Indexes</h3>
<p>You can create an index on a certain column to speed up SELECT performance, such as the <code>price</code> column on the <code>PRODUCT</code> table.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">CREATE</span> <span class="pl-k">INDEX</span> <span class="pl-en">price_index</span> <span class="pl-k">ON</span> PRODUCT(price);</pre></div>
<p>You can also create an index for a column that has unique values, and it will make a special optimization for that case.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">CREATE</span> <span class="pl-k">UNIQUE INDEX</span> <span class="pl-en">name_index</span> <span class="pl-k">ON</span> CUSTOMER(name);</pre></div>
<p>To remove an index, use the <code>DROP</code> command.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">DROP</span> <span class="pl-k">INDEX</span> price_index;</pre></div>
<h3><a id="user-content-97-working-with-dates-and-times" class="anchor" aria-hidden="true" href="#97-working-with-dates-and-times"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>9.7 Working with Dates and Times</h3>
<p>Use the ISO 'yyyy-mm-dd' syntax with strings to treat them as dates easily.</p>
<p>Keep in mind much of this functionality is proprietary to SQLite. Make sure you learn the date and time functionality for your specific database platform.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> <span class="pl-k">*</span> <span class="pl-k">FROM</span> CUSTOMER_ORDER
<span class="pl-k">WHERE</span> SHIP_DATE <span class="pl-k">&lt;</span> <span class="pl-s"><span class="pl-pds">'</span>2015-05-21<span class="pl-pds">'</span></span></pre></div>
<p>To get today's date:</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> <span class="pl-k">DATE</span>(<span class="pl-s"><span class="pl-pds">'</span>now<span class="pl-pds">'</span></span>)</pre></div>
<p>To shift a date:</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> <span class="pl-k">DATE</span>(<span class="pl-s"><span class="pl-pds">'</span>now<span class="pl-pds">'</span></span>,<span class="pl-s"><span class="pl-pds">'</span>-1 day<span class="pl-pds">'</span></span>)
<span class="pl-k">SELECT</span> <span class="pl-k">DATE</span>(<span class="pl-s"><span class="pl-pds">'</span>2015-12-07<span class="pl-pds">'</span></span>,<span class="pl-s"><span class="pl-pds">'</span>+3 month<span class="pl-pds">'</span></span>,<span class="pl-s"><span class="pl-pds">'</span>-1 day<span class="pl-pds">'</span></span>)</pre></div>
<p>To work with times, use <code>hh:mm:ss</code> format.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> <span class="pl-s"><span class="pl-pds">'</span>16:31<span class="pl-pds">'</span></span> <span class="pl-k">&lt;</span> <span class="pl-s"><span class="pl-pds">'</span>08:31<span class="pl-pds">'</span></span></pre></div>
<p>To get today's GMT time:</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> <span class="pl-k">TIME</span>(<span class="pl-s"><span class="pl-pds">'</span>now<span class="pl-pds">'</span></span>)</pre></div>
<p>To shift a time:</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> <span class="pl-k">TIME</span>(<span class="pl-s"><span class="pl-pds">'</span>16:31<span class="pl-pds">'</span></span>,<span class="pl-s"><span class="pl-pds">'</span>+1 minute<span class="pl-pds">'</span></span>)</pre></div>
<p>To merge a date and time, use a DateTime type.</p>
<div class="highlight highlight-source-sql"><pre><span class="pl-k">SELECT</span> <span class="pl-s"><span class="pl-pds">'</span>2015-12-13 16:04:11<span class="pl-pds">'</span></span>
<span class="pl-k">SELECT</span> DATETIME(<span class="pl-s"><span class="pl-pds">'</span>2015-12-13 16:04:11<span class="pl-pds">'</span></span>,<span class="pl-s"><span class="pl-pds">'</span>-1 day<span class="pl-pds">'</span></span>,<span class="pl-s"><span class="pl-pds">'</span>+3 hour<span class="pl-pds">'</span></span>)</pre></div>
<p>To format dates and times a certain way:</p>
<p>``sql
SELECT strftime('%d-%m-%Y', 'now')</p>
<pre><code>
Refer to SQLite documentation
http://www.sqlite.org/lang_datefunc.html

Another helpful tutorial on using dates and times with SQLite.
https://www.tutorialspoint.com/sqlite/sqlite_date_time.htm



# Section X - Moving Forward

### SQL Resources

[Getting Started with SQL (O'Reilly)](http://shop.oreilly.com/product/0636920044994.do) by Thomas Nield

[Learning SQL (O'Reilly)](http://shop.oreilly.com/product/9780596520847.do) by Alan Beaulieu

[Using SQLite (O'Reilly)](http://shop.oreilly.com/product/9780596521196.do) by Jay A. Kreibich

[SQL Practice Problems](https://www.amazon.com/SQL-Practice-Problems-learn-doing/dp/1520807635/) by Sylvia Moestl Vasilik
</code></pre>
</article>
  </div>

    </div>

  

  <details class="details-reset details-overlay details-overlay-dark">
    <summary data-hotkey="l" aria-label="Jump to line"></summary>
    <details-dialog class="Box Box--overlay d-flex flex-column anim-fade-in fast linejump" aria-label="Jump to line">
      <!-- '"` --><!-- </textarea></xmp> --></option></form><form class="js-jump-to-line-form Box-body d-flex" action="" accept-charset="UTF-8" method="get"><input name="utf8" type="hidden" value="&#x2713;" />
        <input class="form-control flex-auto mr-3 linejump-input js-jump-to-line-field" type="text" placeholder="Jump to line&hellip;" aria-label="Jump to line" autofocus>
        <button type="submit" class="btn" data-close-dialog>Go</button>
</form>    </details-dialog>
  </details>


  </div>
  <div class="modal-backdrop js-touch-events"></div>
</div>

    </div>
  </div>

  </div>

        
<div class="footer container-lg px-3" role="contentinfo">
  <div class="position-relative d-flex flex-justify-between pt-6 pb-2 mt-6 f6 text-gray border-top border-gray-light ">
    <ul class="list-style-none d-flex flex-wrap ">
      <li class="mr-3">&copy; 2018 <span title="0.19213s from unicorn-76945c6576-kvv9v">GitHub</span>, Inc.</li>
        <li class="mr-3"><a data-ga-click="Footer, go to terms, text:terms" href="https://github.com/site/terms">Terms</a></li>
        <li class="mr-3"><a data-ga-click="Footer, go to privacy, text:privacy" href="https://github.com/site/privacy">Privacy</a></li>
        <li class="mr-3"><a href="/security" data-ga-click="Footer, go to security, text:security">Security</a></li>
        <li class="mr-3"><a href="https://status.github.com/" data-ga-click="Footer, go to status, text:status">Status</a></li>
        <li><a data-ga-click="Footer, go to help, text:help" href="https://help.github.com">Help</a></li>
    </ul>

    <a aria-label="Homepage" title="GitHub" class="footer-octicon mr-lg-4" href="https://github.com">
      <svg height="24" class="octicon octicon-mark-github" viewBox="0 0 16 16" version="1.1" width="24" aria-hidden="true"><path fill-rule="evenodd" d="M8 0C3.58 0 0 3.58 0 8c0 3.54 2.29 6.53 5.47 7.59.4.07.55-.17.55-.38 0-.19-.01-.82-.01-1.49-2.01.37-2.53-.49-2.69-.94-.09-.23-.48-.94-.82-1.13-.28-.15-.68-.52-.01-.53.63-.01 1.08.58 1.23.82.72 1.21 1.87.87 2.33.66.07-.52.28-.87.51-1.07-1.78-.2-3.64-.89-3.64-3.95 0-.87.31-1.59.82-2.15-.08-.2-.36-1.02.08-2.12 0 0 .67-.21 2.2.82.64-.18 1.32-.27 2-.27.68 0 1.36.09 2 .27 1.53-1.04 2.2-.82 2.2-.82.44 1.1.16 1.92.08 2.12.51.56.82 1.27.82 2.15 0 3.07-1.87 3.75-3.65 3.95.29.25.54.73.54 1.48 0 1.07-.01 1.93-.01 2.2 0 .21.15.46.55.38A8.013 8.013 0 0 0 16 8c0-4.42-3.58-8-8-8z"/></svg>
</a>
   <ul class="list-style-none d-flex flex-wrap ">
        <li class="mr-3"><a data-ga-click="Footer, go to contact, text:contact" href="https://github.com/contact">Contact GitHub</a></li>
        <li class="mr-3"><a href="https://github.com/pricing" data-ga-click="Footer, go to Pricing, text:Pricing">Pricing</a></li>
      <li class="mr-3"><a href="https://developer.github.com" data-ga-click="Footer, go to api, text:api">API</a></li>
      <li class="mr-3"><a href="https://training.github.com" data-ga-click="Footer, go to training, text:training">Training</a></li>
        <li class="mr-3"><a href="https://blog.github.com" data-ga-click="Footer, go to blog, text:blog">Blog</a></li>
        <li><a data-ga-click="Footer, go to about, text:about" href="https://github.com/about">About</a></li>

    </ul>
  </div>
  <div class="d-flex flex-justify-center pb-6">
    <span class="f6 text-gray-light"></span>
  </div>
</div>



  <div id="ajax-error-message" class="ajax-error-message flash flash-error">
    <svg class="octicon octicon-alert" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M8.893 1.5c-.183-.31-.52-.5-.887-.5s-.703.19-.886.5L.138 13.499a.98.98 0 0 0 0 1.001c.193.31.53.501.886.501h13.964c.367 0 .704-.19.877-.5a1.03 1.03 0 0 0 .01-1.002L8.893 1.5zm.133 11.497H6.987v-2.003h2.039v2.003zm0-3.004H6.987V5.987h2.039v4.006z"/></svg>
    <button type="button" class="flash-close js-ajax-error-dismiss" aria-label="Dismiss error">
      <svg class="octicon octicon-x" viewBox="0 0 12 16" version="1.1" width="12" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M7.48 8l3.75 3.75-1.48 1.48L6 9.48l-3.75 3.75-1.48-1.48L4.52 8 .77 4.25l1.48-1.48L6 6.52l3.75-3.75 1.48 1.48L7.48 8z"/></svg>
    </button>
    You can’t perform that action at this time.
  </div>


    
    <script crossorigin="anonymous" integrity="sha512-qVbcYR/5g8/oifC9Zgfsuo5fl+mM/pbLEILf1CurowsqkARdJkBTKkUhThJ+sPKtySRGQfXmVbRZZQg4tRQd/g==" type="application/javascript" src="https://assets-cdn.github.com/assets/frameworks-2eb634cfefb2aa74eb1cba618df67413.js"></script>
    
    <script crossorigin="anonymous" async="async" integrity="sha512-EZANAo7hdudBe9vY3mIW6Bj1DO7QC6r/gOFwrLw06kr0GJnWl90dkR1Hzz6XH1sCOy5Yh+lMewgC6BfYSu0IkA==" type="application/javascript" src="https://assets-cdn.github.com/assets/github-c539d3558a35707f48ef2d6554fff407.js"></script>
    
    
    
  <div class="js-stale-session-flash stale-session-flash flash flash-warn flash-banner d-none">
    <svg class="octicon octicon-alert" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M8.893 1.5c-.183-.31-.52-.5-.887-.5s-.703.19-.886.5L.138 13.499a.98.98 0 0 0 0 1.001c.193.31.53.501.886.501h13.964c.367 0 .704-.19.877-.5a1.03 1.03 0 0 0 .01-1.002L8.893 1.5zm.133 11.497H6.987v-2.003h2.039v2.003zm0-3.004H6.987V5.987h2.039v4.006z"/></svg>
    <span class="signed-in-tab-flash">You signed in with another tab or window. <a href="">Reload</a> to refresh your session.</span>
    <span class="signed-out-tab-flash">You signed out in another tab or window. <a href="">Reload</a> to refresh your session.</span>
  </div>
  <div class="facebox" id="facebox" style="display:none;">
  <div class="facebox-popup">
    <div class="facebox-content" role="dialog" aria-labelledby="facebox-header" aria-describedby="facebox-description">
    </div>
    <button type="button" class="facebox-close js-facebox-close" aria-label="Close modal">
      <svg class="octicon octicon-x" viewBox="0 0 12 16" version="1.1" width="12" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M7.48 8l3.75 3.75-1.48 1.48L6 9.48l-3.75 3.75-1.48-1.48L4.52 8 .77 4.25l1.48-1.48L6 6.52l3.75-3.75 1.48 1.48L7.48 8z"/></svg>
    </button>
  </div>
</div>

  <template id="site-details-dialog">
  <details class="details-reset details-overlay details-overlay-dark lh-default text-gray-dark" open>
    <summary aria-haspopup="dialog" aria-label="Close dialog"></summary>
    <details-dialog class="Box Box--overlay d-flex flex-column anim-fade-in fast">
      <button class="Box-btn-octicon m-0 btn-octicon position-absolute right-0 top-0" type="button" aria-label="Close dialog" data-close-dialog>
        <svg class="octicon octicon-x" viewBox="0 0 12 16" version="1.1" width="12" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M7.48 8l3.75 3.75-1.48 1.48L6 9.48l-3.75 3.75-1.48-1.48L4.52 8 .77 4.25l1.48-1.48L6 6.52l3.75-3.75 1.48 1.48L7.48 8z"/></svg>
      </button>
      <div class="octocat-spinner my-6 js-details-dialog-spinner"></div>
    </details-dialog>
  </details>
</template>

  <div class="Popover js-hovercard-content position-absolute" style="display: none; outline: none;" tabindex="0">
  <div class="Popover-message Popover-message--bottom-left Popover-message--large Box box-shadow-large" style="width:360px;">
  </div>
</div>

<div id="hovercard-aria-description" class="sr-only">
  Press h to open a hovercard with more details.
</div>


  </body>
</html>

