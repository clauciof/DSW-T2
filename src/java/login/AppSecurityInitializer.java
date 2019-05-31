/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 *
 * @author Igor
 */

public class AppSecurityInitializer extends AbstractSecurityWebApplicationInitializer {
  public AppSecurityInitializer() {
      super(AppConfig.class);
  }
}
