/**
 * 
 */
package com.baxter.idc.interfa;

import java.util.List;

import com.baxter.idc.entity.ProductEntity;

/**
 * @author guptas9
 *
 */
public interface MasterDataService {

	public List<ProductEntity> saveMasterDataProducts(String filePath, String extension);
	
}
