/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.mycompany.model.UserAudit;

/**
 *
 * @author User
 */
public interface IUserAuditService {
    public boolean lastLoginDetails(UserAudit useraudit);
}
