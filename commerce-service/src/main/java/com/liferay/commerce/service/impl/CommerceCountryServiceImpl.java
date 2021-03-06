/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.commerce.service.impl;

import com.liferay.commerce.constants.CommerceActionKeys;
import com.liferay.commerce.constants.CommerceConstants;
import com.liferay.commerce.model.CommerceCountry;
import com.liferay.commerce.service.base.CommerceCountryServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.BaseModelSearchResult;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermissionFactory;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author Alessio Antonio Rendina
 * @author Andrea Di Giorgi
 */
public class CommerceCountryServiceImpl extends CommerceCountryServiceBaseImpl {

	@Override
	public CommerceCountry addCommerceCountry(
			Map<Locale, String> nameMap, boolean billingAllowed,
			boolean shippingAllowed, String twoLettersISOCode,
			String threeLettersISOCode, int numericISOCode,
			boolean subjectToVAT, double priority, boolean active,
			ServiceContext serviceContext)
		throws PortalException {

		_portletResourcePermission.check(
			getPermissionChecker(), serviceContext.getScopeGroupId(),
			CommerceActionKeys.MANAGE_COMMERCE_COUNTRIES);

		return commerceCountryLocalService.addCommerceCountry(
			nameMap, billingAllowed, shippingAllowed, twoLettersISOCode,
			threeLettersISOCode, numericISOCode, subjectToVAT, priority, active,
			serviceContext);
	}

	@Override
	public void deleteCommerceCountry(long commerceCountryId)
		throws PortalException {

		CommerceCountry commerceCountry =
			commerceCountryPersistence.findByPrimaryKey(commerceCountryId);

		_portletResourcePermission.check(
			getPermissionChecker(), commerceCountry.getGroupId(),
			CommerceActionKeys.MANAGE_COMMERCE_COUNTRIES);

		commerceCountryLocalService.deleteCommerceCountry(commerceCountry);
	}

	@Override
	public List<CommerceCountry> getBillingCommerceCountries(
		long groupId, boolean billingAllowed, boolean active) {

		return commerceCountryLocalService.getBillingCommerceCountries(
			groupId, billingAllowed, active);
	}

	@Override
	public List<CommerceCountry> getCommerceCountries(
		long groupId, boolean active) {

		return commerceCountryLocalService.getCommerceCountries(
			groupId, active);
	}

	@Override
	public List<CommerceCountry> getCommerceCountries(
			long groupId, boolean active, int start, int end,
			OrderByComparator<CommerceCountry> orderByComparator)
		throws PortalException {

		_portletResourcePermission.check(
			getPermissionChecker(), groupId,
			CommerceActionKeys.MANAGE_COMMERCE_COUNTRIES);

		return commerceCountryLocalService.getCommerceCountries(
			groupId, active, start, end, orderByComparator);
	}

	@Override
	public List<CommerceCountry> getCommerceCountries(
			long groupId, int start, int end,
			OrderByComparator<CommerceCountry> orderByComparator)
		throws PortalException {

		_portletResourcePermission.check(
			getPermissionChecker(), groupId,
			CommerceActionKeys.MANAGE_COMMERCE_COUNTRIES);

		return commerceCountryLocalService.getCommerceCountries(
			groupId, start, end, orderByComparator);
	}

	@Override
	public int getCommerceCountriesCount(long groupId) throws PortalException {
		_portletResourcePermission.check(
			getPermissionChecker(), groupId,
			CommerceActionKeys.MANAGE_COMMERCE_COUNTRIES);

		return commerceCountryLocalService.getCommerceCountriesCount(groupId);
	}

	@Override
	public int getCommerceCountriesCount(long groupId, boolean active)
		throws PortalException {

		_portletResourcePermission.check(
			getPermissionChecker(), groupId,
			CommerceActionKeys.MANAGE_COMMERCE_COUNTRIES);

		return commerceCountryLocalService.getCommerceCountriesCount(
			groupId, active);
	}

	@Override
	public CommerceCountry getCommerceCountry(long commerceCountryId)
		throws PortalException {

		CommerceCountry commerceCountry =
			commerceCountryLocalService.getCommerceCountry(commerceCountryId);

		_portletResourcePermission.check(
			getPermissionChecker(), commerceCountry.getGroupId(),
			CommerceActionKeys.MANAGE_COMMERCE_COUNTRIES);

		return commerceCountry;
	}

	@Override
	public List<CommerceCountry> getShippingCommerceCountries(
		long groupId, boolean shippingAllowed, boolean active) {

		return commerceCountryLocalService.getShippingCommerceCountries(
			groupId, shippingAllowed, active);
	}

	@Override
	public List<CommerceCountry> getWarehouseCommerceCountries(
			long groupId, boolean all)
		throws PortalException {

		_portletResourcePermission.check(
			getPermissionChecker(), groupId,
			CommerceActionKeys.MANAGE_COMMERCE_COUNTRIES);

		return commerceCountryLocalService.getWarehouseCommerceCountries(
			groupId, all);
	}

	@Override
	public BaseModelSearchResult<CommerceCountry> searchCommerceCountries(
			long groupId, SearchContext searchContext)
		throws PortalException {

		_portletResourcePermission.check(
			getPermissionChecker(), groupId,
			CommerceActionKeys.MANAGE_COMMERCE_COUNTRIES);

		return commerceCountryLocalService.searchCommerceCountries(
			searchContext);
	}

	@Override
	public CommerceCountry setActive(long commerceCountryId, boolean active)
		throws PortalException {

		CommerceCountry commerceCountry =
			commerceCountryPersistence.findByPrimaryKey(commerceCountryId);

		_portletResourcePermission.check(
			getPermissionChecker(), commerceCountry.getGroupId(),
			CommerceActionKeys.MANAGE_COMMERCE_COUNTRIES);

		return commerceCountryLocalService.setActive(commerceCountryId, active);
	}

	@Override
	public CommerceCountry updateCommerceCountry(
			long commerceCountryId, Map<Locale, String> nameMap,
			boolean billingAllowed, boolean shippingAllowed,
			String twoLettersISOCode, String threeLettersISOCode,
			int numericISOCode, boolean subjectToVAT, double priority,
			boolean active, ServiceContext serviceContext)
		throws PortalException {

		CommerceCountry commerceCountry =
			commerceCountryPersistence.findByPrimaryKey(commerceCountryId);

		_portletResourcePermission.check(
			getPermissionChecker(), commerceCountry.getGroupId(),
			CommerceActionKeys.MANAGE_COMMERCE_COUNTRIES);

		return commerceCountryLocalService.updateCommerceCountry(
			commerceCountry.getCommerceCountryId(), nameMap, billingAllowed,
			shippingAllowed, twoLettersISOCode, threeLettersISOCode,
			numericISOCode, subjectToVAT, priority, active, serviceContext);
	}

	private static volatile PortletResourcePermission
		_portletResourcePermission =
			PortletResourcePermissionFactory.getInstance(
				CommerceCountryServiceImpl.class, "_portletResourcePermission",
				CommerceConstants.RESOURCE_NAME);

}