<h2><a href="https://leetcode.com/problems/print-zero-even-odd/"><div id="big-omega-company-tags"><div id="big-omega-topbar"><div class="companyTagsContainer" style="overflow-x: hidden; flex-wrap: wrap;"><div class="companyTagsContainer--tag">No companies found for this problem</div></div><div class="companyTagsContainer--chevron"><div style="transform: rotate(180deg);"><svg version="1.1" id="icon" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 32 32" fill="#4087F1" xml:space="preserve" style="width: 20px;"><polygon points="16,22 6,12 7.4,10.6 16,19.2 24.6,10.6 26,12 "></polygon><rect id="_x3C_Transparent_Rectangle_x3E_" class="st0" fill="none" width="32" height="32"></rect></svg></div></div></div></div>1116. Print Zero Even Odd</a></h2><h3>Medium</h3><hr><div><p>You have a function <code>printNumber</code> that can be called with an integer parameter and prints it to the console.</p>

<ul>
	<li>For example, calling <code>printNumber(7)</code> prints <code>7</code> to the console.</li>
</ul>

<p>You are given an instance of the class <code>ZeroEvenOdd</code> that has three functions: <code>zero</code>, <code>even</code>, and <code>odd</code>. The same instance of <code>ZeroEvenOdd</code> will be passed to three different threads:</p>

<ul>
	<li><strong>Thread A:</strong> calls <code>zero()</code> that should only output <code>0</code>'s.</li>
	<li><strong>Thread B:</strong> calls <code>even()</code> that should only output even numbers.</li>
	<li><strong>Thread C:</strong> calls <code>odd()</code> that should only output odd numbers.</li>
</ul>

<p>Modify the given class to output the series <code>"010203040506..."</code> where the length of the series must be <code>2n</code>.</p>

<p>Implement the <code>ZeroEvenOdd</code> class:</p>

<ul>
	<li><code>ZeroEvenOdd(int n)</code> Initializes the object with the number <code>n</code> that represents the numbers that should be printed.</li>
	<li><code>void zero(printNumber)</code> Calls <code>printNumber</code> to output one zero.</li>
	<li><code>void even(printNumber)</code> Calls <code>printNumber</code> to output one even number.</li>
	<li><code>void odd(printNumber)</code> Calls <code>printNumber</code> to output one odd number.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> n = 2
<strong>Output:</strong> "0102"
<strong>Explanation:</strong> There are three threads being fired asynchronously.
One of them calls zero(), the other calls even(), and the last one calls odd().
"0102" is the correct output.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> n = 5
<strong>Output:</strong> "0102030405"
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 1000</code></li>
</ul>
</div>