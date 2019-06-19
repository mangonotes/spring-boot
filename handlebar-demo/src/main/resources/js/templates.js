(function() {
  var template = Handlebars.template, templates = Handlebars.templates = Handlebars.templates || {};
templates['address-template'] = template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var helper, alias1=depth0 != null ? depth0 : (container.nullContext || {}), alias2=helpers.helperMissing, alias3="function", alias4=container.escapeExpression;

  return " <p>You can find me in "
    + alias4(((helper = (helper = helpers.city || (depth0 != null ? depth0.city : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"city","hash":{},"data":data}) : helper)))
    + ". My address is "
    + alias4(((helper = (helper = helpers.number || (depth0 != null ? depth0.number : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"number","hash":{},"data":data}) : helper)))
    + " "
    + alias4(((helper = (helper = helpers.street || (depth0 != null ? depth0.street : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"street","hash":{},"data":data}) : helper)))
    + ".</p>";
},"useData":true});
templates['catalogue'] = template({"1":function(container,depth0,helpers,partials,data) {
    var stack1, helper, alias1=depth0 != null ? depth0 : (container.nullContext || {}), alias2=helpers.helperMissing, alias3="function";

  return "<li>Total inventory count  "
    + ((stack1 = ((helper = (helper = helpers.inventory_count || (depth0 != null ? depth0.inventory_count : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"inventory_count","hash":{},"data":data}) : helper))) != null ? stack1 : "")
    + " </li>\r\n<li>Variant Count "
    + ((stack1 = ((helper = (helper = helpers.variant_count || (depth0 != null ? depth0.variant_count : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"variant_count","hash":{},"data":data}) : helper))) != null ? stack1 : "")
    + "</li>\r\n<li>Total inventory value "
    + ((stack1 = ((helper = (helper = helpers.inventory_value || (depth0 != null ? depth0.inventory_value : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"inventory_value","hash":{},"data":data}) : helper))) != null ? stack1 : "")
    + "</li>\r\n<li>Highest variant price "
    + ((stack1 = ((helper = (helper = helpers.highest_variant_price || (depth0 != null ? depth0.highest_variant_price : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"highest_variant_price","hash":{},"data":data}) : helper))) != null ? stack1 : "")
    + "</li>\r\n<li>Primary category id "
    + ((stack1 = ((helper = (helper = helpers.primary_category_id || (depth0 != null ? depth0.primary_category_id : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"primary_category_id","hash":{},"data":data}) : helper))) != null ? stack1 : "")
    + "</li>\r\n<li>Primary category name "
    + ((stack1 = ((helper = (helper = helpers.primary_category_name || (depth0 != null ? depth0.primary_category_name : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"primary_category_name","hash":{},"data":data}) : helper))) != null ? stack1 : "")
    + "</li>\r\n";
},"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var stack1;

  return "<p>\r\n<ul>\r\n"
    + ((stack1 = helpers["with"].call(depth0 != null ? depth0 : (container.nullContext || {}),(depth0 != null ? depth0.data : depth0),{"name":"with","hash":{},"fn":container.program(1, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "\r\n</ul>";
},"useData":true});
})();