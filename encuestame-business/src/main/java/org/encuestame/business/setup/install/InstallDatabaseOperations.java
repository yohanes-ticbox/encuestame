
package org.encuestame.business.setup.install;


public interface InstallDatabaseOperations {
    void install();

    void upgrade(int version);
}
