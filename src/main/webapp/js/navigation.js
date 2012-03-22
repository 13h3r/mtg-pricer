function Navigation(page) {
    this.items = ko.observableArray([
        new NavigationItem(this, "Last day changes", page.dayChanges.table.load, page.dayChanges),
        new NavigationItem(this, "Editions", page.editions.reload, page.editions),
        new NavigationItem(this, "Export", null, page.upload)
    ]
    );
    this.active = ko.observable(this.items()[0].panel);
}

function NavigationItem(navigation, name, activate, panel) {
    var self = this;
    this.navigation = navigation;
    this.name = name;
    this.activate = activate;
    this.panel = panel;

    this.click = function () {
        //set active at navigation
        self.navigation.active(self.panel);
        //console.log(self.navigation.active());
        //read data
        if( self.activate != null )
            self.activate();
    }
}
