package com.ty.ims.inventory_prject_boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.ims.inventory_prject_boot.dto.Item;
import com.ty.ims.inventory_prject_boot.service.ItemService;
import com.ty.ims.inventory_prject_boot.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("items")
public class ItemController {

	@Autowired
	ItemService service;

	@ApiOperation(value = "Create Item", notes = "Used in Creation of Items")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server Error") })
	@GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<Item>> saveItem(@RequestBody Item item, @RequestParam int inventoryid) {
		return service.serviceSaveItem(item, inventoryid);
	}

	@ApiOperation(value = "Updation of Item", notes = "Used in Updation of Items")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server Error") })
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<Item>> updateItem(@RequestBody Item item, @RequestParam int itemid,
			@RequestParam int inventoryid) {
		return service.serviceUpdateItem(item, itemid, inventoryid);
	}

	@ApiOperation(value = "Finding Item", notes = "Used to find Items by Id")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server Error") })
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<Item>> findItembyid(@RequestParam int itemid) {
		return service.serviceFinditembyid(itemid);
	}

	@ApiOperation(value = "Deleting Item", notes = "Used to Delete Items by Id")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server Error") })
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Item>> deleteItembyid(@PathVariable int itemid) {
		return service.serviceDeleteItem(itemid);
	}

	@ApiOperation(value = "Finding Item by Price", notes = "Used to find Items by Price")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server Error") })
	@GetMapping(value = "itemprice", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<List<Item>>> findbyPriceItem(@RequestParam double price) {
		return service.servicefindbyprice(price);
	}

	@ApiOperation(value = "Finding Item by Quantity", notes = "Used to find Items by Quantity which is greater than the given value")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server Error") })
	@GetMapping(value = "itemqtygreaterthan", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<List<Item>>> filterbyqtygreaterItem(@RequestParam int qty) {
		return service.servicefilterbyqtygreater(qty);
	}

	@ApiOperation(value = "Finding Item by Quantity", notes = "Used to find Items by Quantity which is lesser than the given value")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server Error") })
	@GetMapping(value = "itemqtylesserthan", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<List<Item>>> filterbyqtylesserItem(@RequestParam int qty) {
		return service.servicefilterbyqtylesser(qty);
	}

}
