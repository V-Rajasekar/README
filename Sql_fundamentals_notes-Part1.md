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

