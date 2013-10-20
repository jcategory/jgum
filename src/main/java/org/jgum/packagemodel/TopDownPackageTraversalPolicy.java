package org.jgum.packagemodel;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.jgum.graph.CycleDetection;
import org.jgum.graph.SearchStrategy;
import org.jgum.graph.TraversalPolicy;

import com.google.common.base.Function;

public class TopDownPackageTraversalPolicy extends TraversalPolicy<PackageNode> {

	public static Function<PackageNode, List<PackageNode>> childrenPackagesFunction() {
		return new Function<PackageNode, List<PackageNode>>() {
			@Override
			public List<PackageNode> apply(PackageNode packageNode) {
				return packageNode.getSubpackages();
			}
		};
	}
	
	public static Function<PackageNode, List<PackageNode>> childrenPackagesFunction(final Comparator<PackageNode> comparator) {
		return new Function<PackageNode, List<PackageNode>>() {
			@Override
			public List<PackageNode> apply(PackageNode packageNode) {
				List<PackageNode> subPackages = packageNode.getSubpackages();
				Collections.sort(subPackages, comparator);
				return subPackages;
			}
		};
	}
	
	public TopDownPackageTraversalPolicy(SearchStrategy searchStrategy) {
		super(searchStrategy, CycleDetection.IGNORE, childrenPackagesFunction());
	}
	
	public TopDownPackageTraversalPolicy(SearchStrategy searchStrategy, Comparator<PackageNode> comparator) {
		super(searchStrategy, CycleDetection.IGNORE, childrenPackagesFunction(comparator));
	}

}
