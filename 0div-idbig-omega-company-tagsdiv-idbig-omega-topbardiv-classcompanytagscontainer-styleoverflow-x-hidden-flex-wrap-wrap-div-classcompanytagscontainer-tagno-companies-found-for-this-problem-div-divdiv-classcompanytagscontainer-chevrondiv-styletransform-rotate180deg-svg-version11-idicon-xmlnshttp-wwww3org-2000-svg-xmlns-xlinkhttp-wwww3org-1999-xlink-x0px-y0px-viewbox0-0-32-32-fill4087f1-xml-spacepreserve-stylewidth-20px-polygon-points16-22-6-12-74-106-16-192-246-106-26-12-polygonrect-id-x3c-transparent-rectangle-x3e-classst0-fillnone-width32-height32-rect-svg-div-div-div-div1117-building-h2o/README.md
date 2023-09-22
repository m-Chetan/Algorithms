<h2><a href="https://leetcode.com/problems/building-h2o/"><div id="big-omega-company-tags"><div id="big-omega-topbar"><div class="companyTagsContainer" style="overflow-x: hidden; flex-wrap: wrap;"><div class="companyTagsContainer--tag">No companies found for this problem</div></div><div class="companyTagsContainer--chevron"><div style="transform: rotate(180deg);"><svg version="1.1" id="icon" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 32 32" fill="#4087F1" xml:space="preserve" style="width: 20px;"><polygon points="16,22 6,12 7.4,10.6 16,19.2 24.6,10.6 26,12 "></polygon><rect id="_x3C_Transparent_Rectangle_x3E_" class="st0" fill="none" width="32" height="32"></rect></svg></div></div></div></div>1117. Building H2O</a></h2><h3>Medium</h3><hr><div><p>There are two kinds of threads: <code>oxygen</code> and <code>hydrogen</code>. Your goal is to group these threads to form water molecules.</p>

<p>There is a barrier where each thread has to wait until a complete molecule can be formed. Hydrogen and oxygen threads will be given <code>releaseHydrogen</code> and <code>releaseOxygen</code> methods respectively, which will allow them to pass the barrier. These threads should pass the barrier in groups of three, and they must immediately bond with each other to form a water molecule. You must guarantee that all the threads from one molecule bond before any other threads from the next molecule do.</p>

<p>In other words:</p>

<ul>
	<li>If an oxygen thread arrives at the barrier when no hydrogen threads are present, it must wait for two hydrogen threads.</li>
	<li>If a hydrogen thread arrives at the barrier when no other threads are present, it must wait for an oxygen thread and another hydrogen thread.</li>
</ul>

<p>We do not have to worry about matching the threads up explicitly; the threads do not necessarily know which other threads they are paired up with. The key is that threads pass the barriers in complete sets; thus, if we examine the sequence of threads that bind and divide them into groups of three, each group should contain one oxygen and two hydrogen threads.</p>

<p>Write synchronization code for oxygen and hydrogen molecules that enforces these constraints.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> water = "HOH"
<strong>Output:</strong> "HHO"
<strong>Explanation:</strong> "HOH" and "OHH" are also valid answers.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> water = "OOHHHH"
<strong>Output:</strong> "HHOHHO"
<strong>Explanation:</strong> "HOHHHO", "OHHHHO", "HHOHOH", "HOHHOH", "OHHHOH", "HHOOHH", "HOHOHH" and "OHHOHH" are also valid answers.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>3 * n == water.length</code></li>
	<li><code>1 &lt;= n &lt;= 20</code></li>
	<li><code>water[i]</code> is either <code>'H'</code> or <code>'O'</code>.</li>
	<li>There will be exactly <code>2 * n</code> <code>'H'</code> in <code>water</code>.</li>
	<li>There will be exactly <code>n</code> <code>'O'</code> in <code>water</code>.</li>
</ul>
</div>