## Designing a URL Shortening service like TinyURL
(Note from grokking-the-system-design-interview)

### Example

Lond url: https://www.educative.io/collection/page/5668639101419520/5649050225344512/5668600916475904/
Shorten to: http://tinyurl.com/jlg8zpc

### Requirements

#### Functional 
1. Given a URL, our service should generate a shorter and unique alias of it. The shortened url is about 1/3 the size of the original URL
2. URL shortening is used for optimizing links across devices, tracking individual links to analyze audience and campaign performance, and hiding affiliated original URLs.
3. When users access a short link, our service should redirect them to the original link.
4. Users should optionally be able to pick a custom short link for their URL.
5. Links will expire after a standard default timespan. Users should be able to specify the expiration time.

#### Non-functional 
1. The system should be highly available. This is required because, if our service is down, all the URL redirections will start failing.
2. URL redirection should happen in real-time with minimal latency.
3. Shortened links should not be guessable (not predictable).

### Capacity Estimation and constraints

| Items                 | Speed         | 
| ------------------    |:-------------:| 
| New URLs              | 200/s         | 
| URL redirections	    | 20K/s         | 
| Incoming data	        | 100KB/s       | 
| Outgoing data	        | 100MB/s       |  
| Storage for 5 years   | 15TB          |  
| Cache                 |  170GB        |  

### System APIs