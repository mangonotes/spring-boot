(window.webpackJsonp=window.webpackJsonp||[]).push([[0],{23:function(e,t,n){e.exports=n(36)},28:function(e,t,n){},29:function(e,t,n){e.exports=n.p+"static/media/logo.5d5d9eef.svg"},30:function(e,t,n){},36:function(e,t,n){"use strict";n.r(t);var a=n(0),c=n.n(a),o=n(20),r=n.n(o),s=(n(28),n(29),n(30),n(5)),l=n(9),i=n(10),u=n(12),m=n(11),h=n(13),d=n(7),v=function(e){function t(e){var n;return Object(l.a)(this,t),(n=Object(u.a)(this,Object(m.a)(t).call(this,e))).state={message:""},n}return Object(h.a)(t,e),Object(i.a)(t,[{key:"render",value:function(){return c.a.createElement("div",{class:"container"},c.a.createElement("div",{class:"row"},c.a.createElement("div",{class:"col-sm-4"},c.a.createElement("h3",null,"home controller message",this.state.message),c.a.createElement(d.b,{to:"/ui/contactus",className:"nav-link"},"Contact us"))))}},{key:"componentDidMount",value:function(){var e=this;fetch("/api/home").then(function(e){return e.json()}).then(function(t){e.setState({message:t.response})})}}]),t}(a.Component),p=function(e){function t(){return Object(l.a)(this,t),Object(u.a)(this,Object(m.a)(t).apply(this,arguments))}return Object(h.a)(t,e),Object(i.a)(t,[{key:"render",value:function(){return c.a.createElement("div",{class:"container"},c.a.createElement("div",{class:"row"},c.a.createElement("div",{class:"col-sm-4"},c.a.createElement("h3",null,"Contact us"))))}}]),t}(a.Component);var f=function(){return c.a.createElement("div",null,c.a.createElement(s.c,null,c.a.createElement(s.a,{exact:!0,path:"/",component:v}),c.a.createElement(s.a,{path:"/ui/contactus",component:p})))};var E=function(){return c.a.createElement("div",{className:"App"},c.a.createElement(f,null))};Boolean("localhost"===window.location.hostname||"[::1]"===window.location.hostname||window.location.hostname.match(/^127(?:\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$/));n(35);r.a.render(c.a.createElement(d.a,null,c.a.createElement(E,null)),document.getElementById("root")),"serviceWorker"in navigator&&navigator.serviceWorker.ready.then(function(e){e.unregister()})}},[[23,1,2]]]);
//# sourceMappingURL=main.b08b7f3c.chunk.js.map